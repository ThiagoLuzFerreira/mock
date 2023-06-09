package com.thiago.faker;

import com.github.javafaker.Faker;
import com.thiago.faker.model.Dados;
import com.thiago.faker.model.RbrfCpf;
import com.thiago.faker.repository.RbrfRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final RbrfRepository repository;
    private final Faker faker;

    public SampleDataLoader(RbrfRepository repository, Faker faker) {
        this.repository = repository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
        List<RbrfCpf> objs = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new RbrfCpf(
                        faker.number().digits(11),
                        Integer.parseInt(faker.number().digit()),
                        faker.lorem().sentence(),
                        new Dados(
                                Integer.parseInt(faker.number().digit()),
                                faker.lorem().sentence(),
                                faker.date().between(new Date(2022, 3, 31), new Date(2023, 5, 31)).toString(),
                                faker.name().fullName(),
                                faker.date().birthday().toString(),
                                faker.options().option("masc", "fem"),
                                faker.name().fullName(),
                                faker.number().digits(16),
                                faker.options().option("sim", "nao"),
                                null,
                                faker.date().between(new Date(2022, 3, 31), new Date(2023, 5, 31)).toString(),
                                faker.options().option("sim", "nao"),
                                faker.options().option("sim", "nao"),
                                faker.options().option("sim", "nao"))
                )).collect(Collectors.toList());

        repository.saveAll(objs);
    }
}
