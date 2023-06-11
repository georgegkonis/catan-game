package gr.upatras.ceid.backend.provider;

import org.springframework.stereotype.Component;

@Component
public interface IdProvider<T> {
    T generateId();
}
