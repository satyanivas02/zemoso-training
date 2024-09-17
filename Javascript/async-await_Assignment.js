// Assignment -Promises, async await
function getData(uId) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        console.log("Fetched the data!");
        resolve("skc@gmail.com");  // Resolve the promise with the email
      }, 4000);
    });
  }
  
  console.log("start");
  
  async function showData() {
    const email = await getData("skc");  // Wait for the data to be fetched
    console.log("Email id of the user id is: " + email);
    console.log("end");
  }
  
  showData();
  
  
  