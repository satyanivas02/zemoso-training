import { locators } from "../../utils/constants";
import { BaseHands, BaseEyes } from "../BaseRobot";

export class LoginBaseHands extends BaseHands {
  clickSignIn() {
    this.clickOnId(locators.signInButton);
  }

  performLogin() {
    this.typeTextonDom("name", locators.emailField, Cypress.env("USER_NAME"));
    this.clickOnDomElement(locators.continueButton);
    this.wait(2000);
    this.typeTextonDom("name", locators.passwordField, Cypress.env("PASSWORD"));
    this.clickOnId(locators.signInSubmitButton);
  }

  primedeliveryCheckbox() {
    this.clickDomElementwithXpath(locators.primeDeliveryLink);
    this.clickDomElementwithXpath(locators.primeDeliveryCheckbox);
  }
}
export class LoginEyes extends BaseEyes {
  verifyPrimeDeliveryCheckbox() {
    this.seesDomContainText(locators.primeDeliveryButton, locators.addtocart);
  }

  verifyLogin() {
    this.seesTextWithId(locators.accountGreeting, locators.loginText);
  }
}
