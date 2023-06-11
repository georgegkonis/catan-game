package gr.upatras.ceid.backend.provider;

import java.util.UUID;

public class UuidProvider implements IdProvider<String> {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
