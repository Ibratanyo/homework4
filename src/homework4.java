import java.util.Random;
public class homework4 {

        public static int bossHealth = 700;
        public static int bossDamage = 50;
        public static String bossDefenceType = null;
        public static int[] heroesHealth = {250, 250, 250, 100, 500,250};
        public static int[] heroesDamage = {25, 25, 25, 0, 15,25};
        public static String[] heroesname = {"Zhack", "Mike", "Otis", "Doctor", "Tank","Lovkach"};
        public static Random random = new Random();


        public static void main(String[] args) {
            fightInfo();
            System.out.println();
            while (!isFinished()) {
                round();
            }

        }


        public static void round() {
            bossDefence();
            bossHit();
            doctorHeal();
            heroHit();
            tankCh();
            fightInfo();
        }

        public static void tankCh() {
            int tankblock = bossDamage / 2;  // половина удара босса
            int checkalive = 0;   //переменная ,проверяет число живых героев
            if (heroesHealth[4] > 0) {
                for (int i = 0; i < heroesHealth.length; i++) {
                    if (i == 4) {
                        continue;
                    } else if (heroesHealth[i] > 0) {
                        checkalive += 1;
                        heroesHealth[i]+= tankblock; // к жизни ост участников прибавили 25 баллов
                    }

                }
                heroesHealth[4] -= tankblock*checkalive;
                System.out.println(heroesname[4]+"  take " +tankblock*checkalive +" damage");
            }
        }

        public static void bersek(){
            int block = bossDamage/2;


        }



        public static void doctorHeal() {
            int doctorHealthHero = 20;
            if (heroesHealth[3] > 0) {
                for (int i = 0; i < heroesHealth.length; i++) {
                    if (i == 3) {
                        continue;
                    } else if (heroesHealth[i] > 0) {
                        heroesHealth[i] += doctorHealthHero;
                    }
                }
            }
        }

        public static void bossDefence() {
            int randomIndex = random.nextInt(heroesHealth.length);
            bossDefenceType = heroesname[randomIndex];
        }


        public static boolean isFinished() {
            if (bossHealth <= 0) {
                System.out.println("Heroes won!");
                return true;
            }
            boolean herodead = true;
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesHealth[i] > 0) {
                    herodead = false;
                    break;
                }
            }
            if (herodead) {
                System.out.println("Boss won!");
            }
            return herodead;
        }

        public static void bossHit() {
            if (bossHealth > 0) {
                for (int i = 0; i < heroesHealth.length; i++) {
                    if (heroesHealth[i] < 0) {
                        continue;
                    } else {
                        heroesHealth[i] -= bossDamage;
                    }
                }
            }
        }

        public static void heroHit() {
            for (int i = 0; i < heroesHealth.length; i++) {
                if (heroesname[i].equals(bossDefenceType) && heroesname[i] != heroesname[3]) {
                    int coefficient = random.nextInt(2) + 3;
                    bossHealth -= heroesDamage[i] * coefficient;
                    System.out.println("_____________________________");
                    System.out.println(bossDefenceType + " critical damage: "
                            + ((heroesDamage[i] * coefficient) - heroesDamage[i]));
                } else if (heroesHealth[i] > 0) {
                    bossHealth -= heroesDamage[i];
                }
            }

        }


        public static void fightInfo() {
            System.out.println("________________________");
            if (bossHealth < 0) {
                bossHealth = 0;
            }
            System.out.println("Boss Health: " + bossHealth + " [" + bossDamage + "]\n");
            for (int i = 0; i < heroesname.length; i++) {
                if (heroesHealth[i] < 0) {
                    heroesHealth[i] = 0;
                } else if

                (heroesHealth[i] == 0) {
                    System.out.println(heroesname[i] + "is dead.");
                } else {
                    System.out.println("" +
                            heroesname[i] + " Health: " + heroesHealth[i] + " [" + heroesDamage[i] + "]");
                }

            }

        }

    }


