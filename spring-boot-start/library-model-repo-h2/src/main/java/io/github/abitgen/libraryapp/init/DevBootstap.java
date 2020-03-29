package io.github.abitgen.libraryapp.init;

import io.github.abitgen.libraryapp.model.Author;
import io.github.abitgen.libraryapp.repo.AuthorRepo;
import io.github.abitgen.libraryapp.repo.BookRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    public DevBootstap(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        System.out.println("Dev data Bootstrapped");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        Author eric = new Author("Eric","Evans");
        authorRepo.save(eric);
    }
}
