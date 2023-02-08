package utils;

public enum Messages implements CharSequence {

    TC001("TC001: url health check"),
    TC002("TC002: verify req & resp full data"),
    TC003("TC003: endpoint with data should answer with status code 201 instead of 200"),
    TC004("TC004: fruit test - all the fruits"),
    TC005("TC005: fruit test - apple"),
    TC006("TC006: fruit test - pineapple"),
    TC007("TC007: fruit test - watermelon"),
    TC008("TC008: number test - all the numbers"),
    TC009("TC009: number test - 4"),
    TC010("TC010: number test - 7"),
    TC011("TC011: number test - 1333"),
    TC012("TC012: number test - 2431"),
    TC013("TC013: color test - all the colors"),
    TC014("TC014: color test - green"),
    TC015("TC015: color test - blue"),
    TC016("TC016: color test - yellow"),
    TC017("TC017: not sending payload"),
    TC018("TC018: bad syntax in the payload"),
    TC019("TC019: wrong and dangerous file format"),
    TC020("TC020: empty payload"),
    TC021("TC021: endpoint should not be possible to sort if user does not give what to sort"),
    TC022("TC022: empty value at a sortable"),
    TC023("TC023: endpoint should have been contain value verification"),
    TC024("TC024: endpoint should have been contain value verification"),
    DO_NOT_BE_AFRAID("nem kell megijedni eszem ágába sincs behekerájkodni a leendő munkaadóimhoz :D");

    String text;

    Messages(String text){
        this.text = text;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }

    @Override
    public String toString() {
        return text;
    }

}
