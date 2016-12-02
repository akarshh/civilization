package view;
/**
 * This is an enum class that represents all the
 * Civilizations that the user may chose from
 */
public enum CivEnum {

    ANCIENT_EGYPT {
        @Override
        public String toString() {
            return "Ancient Egypt";
        }
    },
    QIN_DYNASTY {
        @Override
        public String toString() {
            return "Qin Dynasty";
        }
    },
    ROMAN_EMPIRE {
        @Override
        public String toString() {
            return "Roman Empire";
        }
    },
    SKAIKRU {
        @Override
        public String toString() {
            return "Skaikru";
        }
    },
    STARK_DYNASTY {
        @Override
        public String toString() {
            return "Stark Dynasty";
        }
    },
    MORDOR {
        @Override
        public String toString() {
            return "Mordor";
        }
    }
}
