package dev.kaykyfreitas.databasecsv.processor;

import dev.kaykyfreitas.databasecsv.dto.PersonBankDataDto;
import dev.kaykyfreitas.databasecsv.entity.BankData;
import dev.kaykyfreitas.databasecsv.entity.InputFile;
import dev.kaykyfreitas.databasecsv.entity.Person;
import dev.kaykyfreitas.databasecsv.repository.BankDataRepository;
import dev.kaykyfreitas.databasecsv.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonBankDataProcessor implements ItemProcessor<InputFile, PersonBankDataDto> {

    private final BankDataRepository bankDataRepository;

    private final PersonRepository personRepository;

    @Override
    public PersonBankDataDto process(InputFile inputFile) throws Exception {
        PersonBankDataDto personBankDataDto = new PersonBankDataDto();
        BankData bankData = null;
        Person person = null;

        person = personRepository.findByEmail(inputFile.getEmail())
                .orElseThrow(() -> new RuntimeException("Person no found"));

        bankData = bankDataRepository.findByPersonId(person.getId())
                .orElseThrow(() -> new RuntimeException("BankData not found"));

        BeanUtils.copyProperties(person, personBankDataDto);
        BeanUtils.copyProperties(bankData, personBankDataDto);

        System.out.println(personBankDataDto);
        return personBankDataDto;
    }

}
