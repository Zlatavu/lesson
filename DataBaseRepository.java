package Lesson8;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataBaseRepository {
    private static final String DB_PATH = "jdbc:sqlite:target/geekbrains.db";
    private String insertWeather = "insert into weather (city, localDate, minTemperature, maxTemperature) values (?, ?, ?, ?)";
    private String getWeather = "select * from weather";


    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //Из-за проблем с с доступом БД сделала все через один метод...
    public boolean saveWeatherToDataBase1(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setString(3, weather.getMinTemperature());
            saveWeather.setString(4, weather.getMaxTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }
     /*public void saveWeatherToDataBase5(List<Weather> weatherList) throws SQLException {
         try (Connection connection = DriverManager.getConnection(DB_PATH)) {
             PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
             for (Weather weather : weatherList) {
                 saveWeather.setString(1, weather.getCity());
                 saveWeather.setString(2, weather.getLocalDate());
                 saveWeather.setString(3, weather.getMinTemperature());
                 saveWeather.setString(4, weather.getMaxTemperature());
                 saveWeather.addBatch();
             }
             saveWeather.executeBatch();
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         }
         throw new SQLException("Сохранение погоды в базу данных не выполнено!");
     }*/


    public List<Weather> getSavedToDBWeather() {
        List<Weather> weatherList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet weatherResult = statement.executeQuery(getWeather);

            while ((weatherResult.next())){
                System.out.print(weatherResult.getString("city"));
                System.out.print( " ");
                System.out.print(weatherResult.getString("localDate"));
                System.out.print( " ");
                System.out.print(weatherResult.getString("minTemperature"));
                System.out.print( " ");
                System.out.println(weatherResult.getString("maxTemperature"));
                System.out.println( " ");
            }

            while ((weatherResult.next())){
                weatherList.add(new Weather(
                        weatherResult.getString("city"),
                        weatherResult.getString("localDate"),
                        weatherResult.getString("minTemperature"),
                        weatherResult.getString("maxTemperature")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weatherList;
    }


}
