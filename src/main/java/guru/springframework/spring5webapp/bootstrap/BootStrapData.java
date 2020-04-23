package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("SFG Publishing", "15.Street, St-Petersburg, Fl, 06120");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drive Design", "433543245435");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "759034578057");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        Author nfk = new Author("Necip Fazıl", "Kısakürek");
        Book ovb = new Book("O ve Ben", "3457890683");
        Publisher tms = new Publisher("Timaş", "karaca sokak 5, Istanbul, Tr, 34100");
        nfk.getBooks().add(ovb);
        ovb.getAuthors().add(nfk);
        tms.getBooks().add(ovb);
        authorRepository.save(nfk);
        bookRepository.save(ovb);
        publisherRepository.save(tms);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books = " + bookRepository.count());
        System.out.println("Number of authors = " + authorRepository.count());
        System.out.println("Number of publishers = " + publisherRepository.count());
    }

}
