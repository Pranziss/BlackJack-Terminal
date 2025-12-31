package TerecsPlayground.REALPROJECT;

import java.util.Random;
import java.util.Scanner;
//random and input nya main class sya ag backbone jd    
public class BJG {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        User user = new User("Player", 100);
        Dealer dealer = new Dealer("Dealer", 100);
        //manawag dealer and user

        while (user.money > 0 && dealer.money > 0) {
            user.resetHand();
            dealer.resetHand();
            //reset hand 

            System.out.println("\n--- New Round ---");
            System.out.println("Your money: $" + user.money + " | Dealer's money: $" + dealer.money);

            int bet = getBet(user.money);
            //dropmopney

            user.addCard(drawCard());
            user.addCard(drawCard());
            dealer.addCard(drawCard());
            dealer.addCard(drawCard());
            //draw cards to both of us 

            System.out.println("Your hand total: " + user.handTotal);
            System.out.println("Dealer shows: " + dealer.hand[0]);
            //my and dealers cards kay makita 

            playerTurn(user);
            //turn nako

            if (user.handTotal <= 21) {
                dealerTurn(dealer);
            }
            //mo padayun ag dealer if akong cards is dli mo lapas og 21

            determineWinner(user, dealer, bet);
            //final enmding

            System.out.println("\nPress Enter to continue...");
            input.nextLine();
            //entyer?
        }

        if (user.money <= 0) {
            System.out.println("You lost all your money! Game over.");
            //check una if wala jd then kani iya i print nya dna mo repeat goes for both ways
        } else {
            System.out.println("Dealer lost all their money! You win!");
        }
    }

    static int drawCard() {
        return random.nextInt(10) + 2;
        //card nasa 2 and 11
    }

    static int getBet(int moneyAvailable) {
        System.out.print("Place your bet: ");
        int bet = input.nextInt();
        input.nextLine();
        //magask sya pila imo i hagbong sa 100 nmo

        while (bet <= 0 || bet > moneyAvailable) {
            System.out.print("Invalid bet. Try again: ");
            bet = input.nextInt();
            input.nextLine();
            //if ever mo lapas mn gane then ofcc this ang mo guwas
        }
        return bet;
    }

    static void playerTurn(User user) {
        while (true) {
            System.out.println("Your current total: " + user.handTotal);
            System.out.print("Do you want to [Hit] or [Stand]? ");
            String decision = input.nextLine().toLowerCase().trim();
            //hit manngayu stanmd end na padakanay mo

            if (decision.equals("hit")) {
                int card = drawCard();
                user.addCard(card);
                System.out.println("You drew a " + card + ". New total: " + user.handTotal);
                //ma + ag card g hawidan nako usrer

                if (user.handTotal > 21) {
                    System.out.println("You busted!");
                    //if mo lapas
                    break;
                }
            } else if (decision.equals("stand")) {
                System.out.println("You stand with " + user.handTotal);
                //stand before i compare
                break;
            } else {
                System.out.println("Invalid choice. Please type 'Hit' or 'Stand'.");
                //pick sa hit or stand lng if none then this ag outpuit
            }
        }
    }

    static void dealerTurn(Dealer dealer) {
        System.out.println("\nDealer's turn. Dealer total: " + dealer.handTotal);
        while (dealer.handTotal < 17) {
            int card = drawCard();
            dealer.addCard(card);
            System.out.println("Dealer draws a " + card + ". New total: " + dealer.handTotal);
            //dealer nani nga area since user tong ganina
        }
        if (dealer.handTotal > 21) {
            System.out.println("Dealer busted!");
            //if mo lapas dealer then yes
        } else {
            System.out.println("Dealer stands with " + dealer.handTotal);
            //dealer stands 1v1 mi
        }
    }

    static void determineWinner(User user, Dealer dealer, int bet) {
        System.out.println("\n--- Round Results ---");
        System.out.println("Your total: " + user.handTotal);
        System.out.println("Dealer total: " + dealer.handTotal);
        //display hands namo 

        if (user.handTotal > 21) {
            System.out.println("You busted. Dealer wins!");
            user.money -= bet;
            dealer.money += bet;
            //player loss 
        } else if (dealer.handTotal > 21 || user.handTotal > dealer.handTotal) {
            System.out.println("You win the round!");
            user.money += bet;
            dealer.money -= bet;
            //player wins or dealer failed as in mi lapas sya 
        } else if (dealer.handTotal > user.handTotal) {
            System.out.println("Dealer wins the round!");
            user.money -= bet;
            dealer.money += bet;
            //dealer wins lol either mi lapas ka or 21 sya
        } else {
            System.out.println("It's a tie! No money exchanged.");
            //tie = none
        }
    }
}


