import { locators } from "../../utils/constants";
import { BaseHands, BaseEyes } from "../BaseRobot";

export class PaymentHands extends BaseHands {
  addnewPayment() {
    this.clickOnId(locators.cartButton);
    this.clickOnDomElement(locators.proceedToCheckoutButton);
    this.clickDomElementwithXpath(locators.otherUpiApps);
    this.typeTextonDom(
      "placeholder",
      locators.enterUpiIdPlaceholder,
      Cypress.env("UPI_ID")
    );
    this.clickDomElementwithXpath(locators.validateUpiIdButton);
  }
}
export class PaymentEyes extends BaseEyes {
  verifyPayment() {
    this.seesTextWithxpath(locators.verifiedText, locators.paymentVerify);
  }
}
