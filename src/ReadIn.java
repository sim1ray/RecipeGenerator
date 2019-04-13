
public class ReadIn {
  public ArrayList<String> readIn(String filePath) {
    File excelFile = new File(filePath);
    ArrayList<String> elements = new ArrayList<>();
    Scanner reader;
    try {
      reader = new Scanner(excelFile);
      String input = reader.nextLine();
      Scanner lineInput = null;
      int index = 0;
      while (reader.hasNextLine()) {
        input = reader.nextLine();
        if (!input.contains("This document was made with Webix library. http://webix.com")) {
          lineInput = new Scanner(input);
          lineInput.useDelimiter(",");
          days[index] = new Day(lineInput.next(), lineInput.nextDouble(), lineInput.nextDouble(),
              lineInput.nextDouble(), lineInput.nextDouble(), lineInput.nextInt());
            index++;
          lineInput.close();
        }
      }
      reader.close();
      if (index < totalTradingDays) {
        days = trimArray(days, index);
      }
      return days;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  private Day[] trimArray(Day[] array, int length) {
    Day[] newArray = new Day[length];
    int index = 0;
    while (index < length) {
      newArray[index] = array[index];
      index++;
    }
    return newArray;
  }
}
