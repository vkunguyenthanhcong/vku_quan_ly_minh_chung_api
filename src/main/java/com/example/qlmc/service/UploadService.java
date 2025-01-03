package com.example.qlmc.service;

import com.example.qlmc.entity.Res;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;

@org.springframework.stereotype.Service
public class UploadService {
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String SERVICE_ACOUNT_KEY_PATH = getPathToGoodleCredentials();

    private static String getPathToGoodleCredentials() {
        String currentDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(currentDirectory, "cred.json");
        return filePath.toString();
    }

    public Res uploadImageToDrive(String nameFile, File file) throws GeneralSecurityException, IOException {
        Res res = new Res();

        try{    
            String folderId = "1Ro7d1Av5YFXT-VrTIIVYzK2QGQyqQmud";
            Drive drive = createDriveService();
            com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
            fileMetaData.setName(nameFile);
            fileMetaData.setParents(Collections.singletonList(folderId));
            FileContent mediaContent = new FileContent("application/octet-stream", file);
            com.google.api.services.drive.model.File uploadedFile = drive.files().create(fileMetaData, mediaContent)
                    .setFields("id").execute();
            System.out.println("IMAGE ID: " + uploadedFile.getId());
            file.delete();
            res.setStatus(200);
            res.setMessage("File Successfully Uploaded To Drive");
            res.setUrl(uploadedFile.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            res.setStatus(500);
            res.setMessage(e.getMessage());
        }
        return  res;
    }
    public Res createFolder(String name, String parentIdGoogleDrive) throws GeneralSecurityException, IOException {
        Res res = new Res();
        try{
            String folderName = name;
            String parentFolderId = parentIdGoogleDrive;

            Drive drive = createDriveService();
            com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
            fileMetaData.setName(folderName);
            fileMetaData.setMimeType("application/vnd.google-apps.folder");

            if (parentFolderId != null) {
                fileMetaData.setParents(Collections.singletonList(parentFolderId));
            }
            com.google.api.services.drive.model.File folder = drive.files().create(fileMetaData)
                    .setFields("id")  // Only request the folder ID
                    .execute();
            res.setStatus(200);
            res.setMessage("Folder Successfully Created");
            res.setUrl(folder.getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
            res.setStatus(500);
            res.setMessage(e.getMessage());
        }
        return  res;
    }
    public Res deleteGoogleDrive(String idGoogleDrive) throws GeneralSecurityException, IOException {
        Res res = new Res();
        try{
            String folderId = idGoogleDrive;
            Drive drive = createDriveService();
            drive.files().delete(folderId).execute();
            System.out.println("Folder deleted successfully");
            res.setStatus(200);
            res.setMessage("Folder Successfully Deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
            res.setStatus(500);
            res.setMessage(e.getMessage());
        }
        return  res;
    }


    private Drive createDriveService() throws GeneralSecurityException, IOException {

        GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACOUNT_KEY_PATH))
                .createScoped(Collections.singleton(DriveScopes.DRIVE));

        return new Drive.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                credential)
                .build();

    }
    public Res createShortcut(String name, String parentFolderId, String targetFileId) throws GeneralSecurityException, IOException {
        Res res = new Res();

        try {
            Drive driveService = createDriveService();

            com.google.api.services.drive.model.File shortcutMetadata = new com.google.api.services.drive.model.File();
            shortcutMetadata.setName(name);
            shortcutMetadata.setMimeType("application/vnd.google-apps.shortcut");
            shortcutMetadata.setParents(Collections.singletonList(parentFolderId));

            com.google.api.services.drive.model.File.ShortcutDetails shortcutDetails = new com.google.api.services.drive.model.File.ShortcutDetails();
            shortcutDetails.setTargetId(targetFileId);
            shortcutMetadata.setShortcutDetails(shortcutDetails);

            com.google.api.services.drive.model.File shortcut = driveService.files().create(shortcutMetadata)
                    .setFields("id")  // Only request the shortcut ID
                    .execute();
            String shortcutUrl = shortcut.getId();

            res.setStatus(200);
            res.setMessage("Shortcut successfully created");
            res.setUrl(shortcutUrl);
        } catch (Exception e) {
            System.out.println("Error creating shortcut: " + e.getMessage());
            res.setStatus(500);
            res.setMessage("Error creating shortcut: " + e.getMessage());
        }

        return res;
    }
    public Res removeShortcut(String fileId) throws GeneralSecurityException, IOException {
        Res res = new Res();

        try {
            Drive driveService = createDriveService();
            driveService.files().delete(fileId).execute();
            res.setStatus(200);
            res.setMessage("Shortcut successfully removed");
        } catch (Exception e) {
            System.out.println("Error removing shortcut: " + e.getMessage());
            res.setStatus(500);
            res.setMessage("Error removing shortcut: " + e.getMessage());
        }

        return res;
    }


}