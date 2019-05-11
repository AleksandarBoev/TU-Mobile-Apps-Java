package tu.practise.firm.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import tu.practise.firm.database.FirmDatabase;
import tu.practise.firm.database.daos.TownDao;
import tu.practise.firm.database.entities.Town;
import tu.practise.firm.domain.models.binding.TownBindingModel;
import tu.practise.firm.exceptions.InvalidTownException;

@RunWith(MockitoJUnitRunner.class)
public class TownServiceImplTest extends BaseValidationTesting {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static final String VALID_TOWN_NAME = "Sofia";
    private static final String VALID_TOWN_NAME_MULTIPLE_WORDS = "Veliko Tarnovo";
    private static final Integer VALID_TOWN_POSTAL_CODE = 1111;

    private static final String INVALID_TOWN_NAME_LOWER_CASE = "sofia";
    private static final String INVALID_TOWN_NAME_UPPER_CASE = "VELIKO TARNOVO";

    private static final Integer INVALID_TOWN_POSTAL_CODE1 = 111;
    private static final Integer INVALID_TOWN_POSTAL_CODE2 = 11111;

    private TownBindingModel townBindingModel;
    @Mock
    private FirmDatabase mockedFirmDb;
    @Mock
    private TownDao mockedTownDao;
    private TownService townService;

    @Before
    public void init(){
        townBindingModel = new TownBindingModel(VALID_TOWN_NAME, VALID_TOWN_POSTAL_CODE);
        Mockito.when(mockedFirmDb.townDao()).thenReturn(mockedTownDao);

        townService = new TownServiceImpl(mockedFirmDb);
    }

    @Test
    public void save_whenValidCredentials_noExceptionsThrown() {
        townService.save(townBindingModel);
        Mockito.verify(mockedTownDao).saveTown((Town)Mockito.any());
    }

    @Test
    public void save_whenValidCredentials2_noExceptionsThrown() {
        townBindingModel.setName(VALID_TOWN_NAME_MULTIPLE_WORDS);
        townService.save(townBindingModel);
        Mockito.verify(mockedTownDao).saveTown((Town)Mockito.any());
    }

    @Test
    public void save_whenLowerThanMinLengthTownName_throwsExceptionWithCorrectMessage() {
        //Arrange & Assert
        thrown.expect(InvalidTownException.class);
        thrown.expectMessage(TownServiceImpl.INVALID_TOWN_NAME_LENGTH_MESSAGE);
        townBindingModel.setName(super.strRepeat('a', TownServiceImpl.TOWN_NAME_MIN_LENGTH - 1));

        //Act
        townService.save(townBindingModel);
    }

    @Test
    public void save_whenHigherThanMaxLengthTownName_throwsExceptionWithCorrectMessage() {
        //Arrange & Assert
        thrown.expect(InvalidTownException.class);
        thrown.expectMessage(TownServiceImpl.INVALID_TOWN_NAME_LENGTH_MESSAGE);
        townBindingModel.setName(super.strRepeat('a', TownServiceImpl.TOWN_NAME_MAX_LENGTH + 1));

        //Act
        townService.save(townBindingModel);
    }

    @Test
    public void save_whenInvalidFormatAllLowerCase_throwsExceptionWithCorrectMessage() {
        thrown.expect(InvalidTownException.class);
        thrown.expectMessage(TownServiceImpl.INVALID_TOWN_NAME_FORMAT_MESSAGE);
        townBindingModel.setName(INVALID_TOWN_NAME_LOWER_CASE);

        townService.save(townBindingModel);
    }

    @Test
    public void save_whenInvalidFormatAllUpperCase_throwsExceptionWithCorrectMessage() {
        thrown.expect(InvalidTownException.class);
        thrown.expectMessage(TownServiceImpl.INVALID_TOWN_NAME_FORMAT_MESSAGE);
        townBindingModel.setName(INVALID_TOWN_NAME_UPPER_CASE);

        townService.save(townBindingModel);
    }

    @Test
    public void save_whenLowerThanMinimumLengthPostalCode_throwsExceptionWithCorrectMessage() {
        thrown.expect(InvalidTownException.class);
        thrown.expectMessage(TownServiceImpl.INVALID_TOWN_POSTAL_CODE);
        Integer invalidPostalCode = Integer.parseInt(super.strRepeat('1', TownServiceImpl.POSTAL_CODE_REQUIRED_LENGTH - 1));
        townBindingModel.setPostalCode(invalidPostalCode);

        townService.save(townBindingModel);
    }

    @Test
    public void save_whenHigherThanMaximumLengthPostalCode_throwsExceptionWithCorrectMessage() {
        thrown.expect(InvalidTownException.class);
        thrown.expectMessage(TownServiceImpl.INVALID_TOWN_POSTAL_CODE);
        Integer invalidPostalCode = Integer.parseInt(super.strRepeat('1', TownServiceImpl.POSTAL_CODE_REQUIRED_LENGTH + 1));
        townBindingModel.setPostalCode(invalidPostalCode);

        townService.save(townBindingModel);
    }
}
