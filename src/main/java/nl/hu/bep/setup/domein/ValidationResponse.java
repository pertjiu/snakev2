package nl.hu.bep.setup.domein;

public class ValidationResponse {
    private boolean isValid;

    public ValidationResponse(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}

