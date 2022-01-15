package com.wallman.greetingmessage.repository;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GreetingsRepository {

    private static final String PROJECT_ID = "gcp-test-danwal";
    private final Firestore db;

    public GreetingsRepository() throws IOException {
        FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
                .setProjectId(PROJECT_ID)
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .build();
        db = firestoreOptions.getService();
    }

    public List<String> getAll() {
        try {
            return db.collection("greetings").get().get().getDocuments().stream()
                    .map(document -> document.getString("message"))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
