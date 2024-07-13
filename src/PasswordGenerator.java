import java.util.Random;

//this class works as the backend and will generate the password
public class PasswordGenerator {
    //character pools
    //these strings will hold the characters/numbers/symbols that will be randomly generated
    public static final String LOWECASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SPECIAL_SYMBOLS ="!@#$%^&*()-_=+[]{};:,.<>/?";

    //the random class allows us to generate a random number which will be used to randomly choose the characters
    private final Random random;

    //constructor
    public PasswordGenerator() {random = new Random();}

    //length -length of the password to be generated(taken from the user)
    //includeUpperCase and etc.. considers if the password should include uppercase, lowercase.etc..(taken from the user)
    public String generatePassword(int length,
                                   boolean includeUppercase,
                                   boolean includeLowercase,
                                   boolean includeNumbers,
                                   boolean includeSpecialSymbols){
        //we will use string builder over string for better efficiency
        StringBuilder passwordBuilder = new StringBuilder();

        //store valid characters (toggle states)
        String validCharacters = "";
        if(includeUppercase) validCharacters += UPPERCASE_CHARACTERS;
        if(includeLowercase) validCharacters += LOWECASE_CHARACTERS;
        if(includeNumbers) validCharacters += NUMBERS;
        if(includeSpecialSymbols) validCharacters += SPECIAL_SYMBOLS;

        //build password
        for(int i = 0; i < length; i++) {
            //generate a random index
            int randomIndex = random.nextInt(validCharacters.length());

            //get the char base on the random index
            char randomChar = validCharacters.charAt(randomIndex);

            //store char into password builder
            passwordBuilder.append(randomChar);

            //do this until we have reached the length that the user has provided
        }

        //return the result
        return passwordBuilder.toString();
    }
}
