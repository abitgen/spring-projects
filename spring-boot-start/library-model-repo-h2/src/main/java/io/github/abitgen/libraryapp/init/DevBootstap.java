package io.github.abitgen.libraryapp.init;

import io.github.abitgen.libraryapp.model.Author;
import io.github.abitgen.libraryapp.model.Book;
import io.github.abitgen.libraryapp.model.Publisher;
import io.github.abitgen.libraryapp.repo.AuthorRepo;
import io.github.abitgen.libraryapp.repo.BookRepo;
import io.github.abitgen.libraryapp.repo.PublisherRepo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;

    public DevBootstap(AuthorRepo authorRepo,
                       BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){

            Publisher addison = new Publisher("Addison-Wesley"," New York Street");
        Publisher wrox = new Publisher("Wrox"," New York Street");
        publisherRepo.save(addison);
        publisherRepo.save(wrox);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","12345", addison);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author johnson = new Author("Rod","Johnson");
        Book javaee = new Book("J2EE design and Development","23432", wrox);
        johnson.getBooks().add(javaee);
        javaee.getAuthors().add(johnson);
        authorRepo.save(johnson);
        bookRepo.save(javaee);

        System.out.println("Dev data Bootstrapped");

    }
}
