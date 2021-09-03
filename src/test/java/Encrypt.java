package test.java;

public class Encrypt {
    private int mKey;

    public int getmKey() {
        return mKey;
    }

    public void setmKey(int mKey) {
        this.mKey = mKey;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    private String mText;

    Encrypt(String text, int key) {
        this.mText = text;
        this.mKey = key;
    }

    public boolean isString(){
        for (int index = 0; index < this.mText.length(); index++){
            if (this.mText.charAt(index) >= '0' && this.mText.charAt(index) <= '9'){
                System.out.println("Expected characters or words");
                return false;
            }
        }
        return true;
    }

    public boolean isInRange(){
        return this.mKey >= 1 && this.mKey <= 25;
    }

    public String forward(){
        char[] newCharText = mText.toCharArray();

        for (int index = 0; index < newCharText.length; index++){

            if (Character.isUpperCase(newCharText[index])){
                int castText = ((int) newCharText[index] - 65 + this.mKey) % 26 + 65;
                newCharText[index] = (char)castText;
            }

            else if (Character.isLowerCase(newCharText[index])){
                int castText = ((int) newCharText[index] - 97 + this.mKey) % 26 + 97;
                newCharText[index] = (char)castText;
            }
        }

        final String newS = String.valueOf(newCharText);
        return newS;
    }
}
