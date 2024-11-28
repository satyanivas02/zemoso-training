//Example 1 for demonstrating how the function can be passed inside anothe function
// Function to greet someone
function greet(name) {
    return `Hello, ${name}!`;
}
  
  // Function that accepts another function as an argument
  function displayGreeting(greetingFunction, userName) {
    // Calling the function passed as a parameter
    const message = greetingFunction(userName);
    console.log(message);
  }
  
  // Passing the greet function as an argument to displayGreeting
  displayGreeting(greet, "John"); // Output: Hello, John!


//Example 2 for demonstrating how the function can be passed inside anothe function
function cookDinner(chef, ingredient) {
    const dish = chef(ingredient);  // The chef will cook with the ingredient
    console.log(dish);  // Show what was cooked
  }
  
  function italianChef(ingredient) {
    return `Pasta with ${ingredient}`;
  }
  
  function mexicanChef(ingredient) {
    return `Tacos with ${ingredient}`;
  }
  
  cookDinner(italianChef, "tomato");  // Output: Pasta with tomato
  cookDinner(mexicanChef, "chicken");  // Output: Tacos with chicken
  


// An arrow function takes two arguments firstName and lastName and returns a 2 letter string that represents the first letter of both the arguments
const getInitials = (firstName, lastName) => {
  return firstName[0] + lastName[0];
};

console.log(getInitials("Satyanivas", "Miryala")); // Output: 'SM'
