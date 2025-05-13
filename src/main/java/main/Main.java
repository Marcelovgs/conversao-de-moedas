package main; 

public class Main {
    public static void main(String[] args) {
        // Teste da conversão
        main.CurrencyConverter converter = new main.CurrencyConverter();
        double amountInUSD = 100.0;  // Exemplo: 100 Reais
        String fromCurrency = "BRL";
        String toCurrency = "USD";

        double convertedAmount = converter.converter(fromCurrency, toCurrency, amountInUSD);
        System.out.println(amountInUSD + " " + fromCurrency + " é equivalente a " + convertedAmount + " " + toCurrency);
    }
}
