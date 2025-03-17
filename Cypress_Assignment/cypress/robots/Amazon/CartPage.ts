import { locators } from "../../utils/constants";
import { BaseHands, BaseEyes } from "../BaseRobot";

export class CartHands extends BaseHands {
  addToCart() {
    this.clickDomElementwithXpath(locators.addToCartButton);
  }

  closeCart() {
    this.clickOnId(locators.closeCartButton);
  }
}
export class CartEyes extends BaseEyes {
  verifyAddToCart() {
    this.seesDomContainText(locators.cartCount, locators.cartcountno);
  }
}
