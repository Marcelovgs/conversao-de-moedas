package main;

import com.google.gson.Gson;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private static final String API_KEY = "689782e8c073196d82ca36ee";  // Sua chave da API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/"; // URL com a chave da API

    public double converter(String fromCurrency, String toCurrency, double amount) {
        try {
            // Monta a URL para a requisição
            String urlStr = API_URL + fromCurrency;
            URL url = new URL(urlStr);

            // Abre a conexão e faz a requisição
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Lê a resposta da API
            Scanner scanner = new Scanner(connection.getInputStream());
            StringBuilder response = new StringBuilder();
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            scanner.close();

            // Imprimir a resposta da API para depuração
            System.out.println("Resposta da API: " + response.toString());

            // Converte o JSON para o objeto Java usando o Gson
            Gson gson = new Gson();
            ExchangeRateResponse exchangeRateResponse = gson.fromJson(response.toString(), ExchangeRateResponse.class);

            // Verifica se a taxa de conversão está presente
            Map<String, Double> conversionRates = exchangeRateResponse.getConversionRates();
            if (conversionRates != null && conversionRates.containsKey(toCurrency)) {
                // Acessa as taxas de conversão
                double rate = conversionRates.get(toCurrency);
                // Retorna o valor convertido
                return amount * rate;
            } else {
                // Caso a taxa de conversão não seja encontrada
                System.out.println("Erro: taxa de conversão não encontrada para " + toCurrency);
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
