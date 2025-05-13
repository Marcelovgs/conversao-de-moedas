package main;  // Certifique-se de que a classe Main está no pacote correto

public class Main {
    public static void main(String[] args) {
        // Teste da conversão
        main.CurrencyConverter converter = new main.CurrencyConverter();
        double amountInUSD = 100.0;  // Exemplo: 100 dólares
        String fromCurrency = "BRL";
        String toCurrency = "USD";

        double convertedAmount = converter.converter(fromCurrency, toCurrency, amountInUSD);
        System.out.println(amountInUSD + " " + fromCurrency + " é equivalente a " + convertedAmount + " " + toCurrency);
    }
}
