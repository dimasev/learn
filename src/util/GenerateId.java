package util;

public class GenerateId {

        private static final int MIN_VALUE = 10000;
        private static final int MAX_VALUE = 99999;
    // FIXME: 08.01.2023 add constructor?
        private static int orderId = MIN_VALUE;
        public static int generateNextId() {
            if (orderId>MAX_VALUE)
                orderId = MIN_VALUE;
            return orderId++;
        }
    }
