package javalearning.restapp.data;

public class RequestParams {
    private String word;
    private String sign;

    public RequestParams() {
        this.word = "";
        this.sign = "";
    }

    public RequestParams(String word, String sign) {
        this.word = word;
        this.sign = sign;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getWord() {
        return this.word;
    }

    public String getSign() {
        return this.sign;
    }

    @Override
    public int hashCode() {
        return this.toString().length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        RequestParams requestParams = (RequestParams) obj;
        return (this.word.equals(requestParams.word) && this.sign.equals(requestParams.sign));
    }

    @Override
    public String toString() {
        return "{word:\"" + word + "\", sign:\"" + sign + "\"}";
    }
}
