import { CartEyes, CartHands } from "../robots/Amazon/CartPage";
import { TodaysDealsEyes, TodaysDealsHands } from "../robots/Amazon/DealsPage";
import { HomePageDependencies, HomePageEyes } from "../robots/Amazon/HomePage";
import { NavigationEyes, NavigationHands } from "../robots/Amazon/Navigation";
import { SearchEyes, SearchHands } from "../robots/Amazon/SearchPage";

Cypress.on("uncaught:exception", (err, runnable) => {
  if (
    err.message.includes("Failed to execute 'observe' on 'MutationObserver'")
  ) {
    return false;
  }
  return true;
});

describe("Amazon Test Suite", () => {
  const homepagedependencies = new HomePageDependencies();
  const homepageeyes = new HomePageEyes();
  const todaysDealsEyes = new TodaysDealsEyes();
  const todaysDealsHands = new TodaysDealsHands();
  const cartHands = new CartHands();
  const searchHands = new SearchHands();
  const searchEyes = new SearchEyes();
  const navigationHands = new NavigationHands();
  const navigationEyes = new NavigationEyes();
  const carteyes = new CartEyes();

  before(() => {
    homepagedependencies.visitAmazonPage();
  });

  it("Should open Today's Deals and add to cart", () => {
    todaysDealsEyes.seesTodaysDeals();
    todaysDealsHands.clickOnTodaysDeals();
    todaysDealsHands.selectThirdDeal();
    cartHands.addToCart();
  });

  it("Should click and verify the cart", () => {
    carteyes.verifyAddToCart();
    cartHands.closeCart();
  });

  it("Search Mobiles and display last displayed item details", () => {
    searchHands.searchMobiles();
    searchEyes.verifycategory();
    searchHands.getLastDisplayedItems();
  });

  it("Navigate to mobiles and back to main menu", () => {
    navigationHands.navigateToMobilesAndBack();
    navigationEyes.verifyMobilesSelection();
    navigationHands.backtoMainMenu();
  });
});
