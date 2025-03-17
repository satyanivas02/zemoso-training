import { AddressEyes, AddressHands } from "../robots/Amazon/AdressPage";
import { HomePageDependencies } from "../robots/Amazon/HomePage";
import { LoginBaseHands, LoginEyes } from "../robots/Amazon/LoginPage";
import { OrderBaseEyes, OrderBaseHands } from "../robots/Amazon/OrderPage";
import { PaymentEyes, PaymentHands } from "../robots/Amazon/PaymentPage";

Cypress.on("uncaught:exception", (err, runnable) => {
  if (
    err.message.includes("Failed to execute 'observe' on 'MutationObserver'")
  ) {
    return false;
  }
  return true;
});

describe("Amazon Test Suite with login", () => {
  const homepagedependencies = new HomePageDependencies();
  const loginBaseHands = new LoginBaseHands();
  const orderBaseHands = new OrderBaseHands();
  const orderBaseEyes = new OrderBaseEyes();
  const addressHands = new AddressHands();
  const addressEyes = new AddressEyes();
  const paymentHands = new PaymentHands();
  const paymentEyes = new PaymentEyes();
  const loginEyes = new LoginEyes();

  it("visit homepage and perform Login", () => {
    homepagedependencies.visitAmazonPage();
    loginBaseHands.clickSignIn();
    loginBaseHands.performLogin();
    loginEyes.verifyLogin();
  });

  it("click on Amazon Prime delivery check box", () => {
    loginBaseHands.primedeliveryCheckbox();
    loginEyes.verifyPrimeDeliveryCheckbox();
  });
  it("click on orders and select past one year order", () => {
    orderBaseHands.clickOrders();
    orderBaseHands.pastOrder();
    orderBaseEyes.verifyPastOrder();
  });

  it("add new Adress and verify", () => {
    orderBaseHands.clickOrders();
    addressHands.addNewAddress();
    addressEyes.verifyAddress();
  });
  it("add new Payment and verify", () => {
    orderBaseHands.clickOrders();
    paymentHands.addnewPayment();
    paymentEyes.verifyPayment();
  });
});
