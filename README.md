# Blackjack Java Game 🎲

A **console-based Blackjack game** implemented in Java. Play against a dealer, place bets, and try to get as close as possible to **21** without going over.  

---  

## Features ✨  

- **Player vs Dealer** gameplay  
- Betting system with starting money  
- Random card drawing (values 2–11)  
- Player choices: **Hit** or **Stand**  
- Dealer follows standard Blackjack rules (hits until reaching 17)  
- Round-based gameplay until either player or dealer runs out of money  
- Handles busts, wins, losses, and ties  

---  

## Getting Started 🏁  

### Prerequisites  

- Java JDK installed (version 8 or higher)  
- Terminal or command prompt  

### Installation & Running  

1. **Clone the repository**  

```bash
git clone https://github.com/Pranziss/Blackjack-Terminal.git
```  

2. **Navigate to the project folder**  

```bash
cd BlackjackJava
```  

3. **Compile the code**  

```bash
javac BJG.java User.java Dealer.java
```  

4. **Run the game**  

```bash
java TerecsPlayground.REALPROJECT.BJG
```  

---  

## How to Play 🎮  

1. Start the game – both player and dealer start with **$100**.  
2. Place a bet for the round.  
3. Both player and dealer are dealt 2 cards.  
4. Player chooses:  
   - **Hit** – draw a new card  
   - **Stand** – keep current hand  
5. Dealer automatically plays its turn.  
6. Round ends with a winner, loser, or tie.  
7. Game continues until either player or dealer runs out of money.  

---  

## Gameplay Example 📝  

```
Welcome to Blackjack!
Your money: $100 | Dealer's money: $100
Place your bet: 20

Your hand total: 15
Dealer shows: 8
Do you want to [Hit] or [Stand]? hit
You drew a 5. New total: 20
Do you want to [Hit] or [Stand]? stand
You stand with 20

Dealer's turn. Dealer total: 14
Dealer draws a 6. New total: 20
Dealer stands with 20

--- Round Results ---
Your total: 20
Dealer total: 20
It's a tie! No money exchanged.
```  

---  

## Project Structure 📂  

- `BJG.java` – Main game class handling game logic  
- `User.java` – Class representing the player  
- `Dealer.java` – Class representing the dealer  
- `Random` – Used for card generation  
- `Scanner` – Used for player input  

---  

## Notes ⚠️  

- Cards are numeric only (2–11), no suits included.  
- Player cannot bet more money than they currently have.  
- Game ends when either the player or dealer loses all money.  

---  

## License 📝  

This project is open-source and licensed under the [MIT License](LICENSE).  

---  

Made with ❤️ by Pranziss
