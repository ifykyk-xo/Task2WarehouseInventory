public class Main {
    public static void main(String[] args) {

        // Завдання 2
        String[] items = {
                "Ноутбук",
                "Смартфон",
                "Бездротові навушники",
                "Механічна клавіатура",
                "Монітор 27\""
        };

        int[] quantities = {8, 3, 25, 4, 12};

        double[] prices = {
                28500.0, 19200.0, 1850.0, 3100.0, 9400.0
        };

        double[] totalValues = new double[items.length];

        double totalWarehouseValue = 0;
        int maxIndex = 0;

        for (int i = 0; i < items.length; i++) {
            totalValues[i] = quantities[i] * prices[i];
            totalWarehouseValue += totalValues[i];

            if (totalValues[i] > totalValues[maxIndex]) {
                maxIndex = i;
            }
        }

        System.out.println("=================== ЗВІТ СКЛАДУ ЕЛЕКТРОНІКИ ===================");
        System.out.println("№ | Назва товару | Кількість | Ціна за шт. | Сумарна вартість");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < items.length; i++) {
            System.out.println(
                    (i + 1) + " | "
                            + items[i] + " | "
                            + quantities[i] + " шт. | "
                            + prices[i] + " грн | "
                            + totalValues[i] + " грн"
            );
        }

        System.out.println("---------------------------------------------------------------");

        totalWarehouseValue = Math.round(totalWarehouseValue * 100.0) / 100.0;

        System.out.println("Загальна вартість складу: "
                + totalWarehouseValue + " грн");

        System.out.println("Найбільший капітал у товарі: "
                + items[maxIndex] + " ("
                + totalValues[maxIndex] + " грн)");

        System.out.println();
        System.out.println("ДЕФІЦИТНІ ПОЗИЦІЇ (менше 5 шт.):");

        boolean shortageFound = false;

        for (int i = 0; i < items.length; i++) {
            if (quantities[i] < 5) {
                System.out.println("- " + items[i]
                        + " (залишилось: " + quantities[i] + " шт.)"
                        + " -> УВАГА: Терміново замовити постачальнику!");

                shortageFound = true;
            }
        }

        if (!shortageFound) {
            System.out.println("Дефіцитних товарів немає.");
        }

        System.out.println("===============================================================");
    }
}
