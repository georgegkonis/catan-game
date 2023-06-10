package gr.upatras.ceid.backend.providers;

import org.springframework.stereotype.Component;

@Component
public interface IdProvider<T> {
    T generateId();
}
