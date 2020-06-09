package it.cattolica.azurewebappsite;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {

    static final Log log = LogFactory.getLog(Startup.class);

    private RecordRepository recordRepository;

    public Startup(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.recordRepository.deleteAll();
        this.recordRepository.save(new Record("Pino"));
        this.recordRepository.save(new Record("Gino"));
        this.recordRepository.save(new Record("Tino"));
        log.info(String.format("Inserted %d records", this.recordRepository.count()));
    }
}

