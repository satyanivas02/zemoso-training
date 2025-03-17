export const locators = {
  breadcrumbsCrumb: "li[class='breadcrumbs__crumb'] a[class='a-link-normal']",
  yourAddresses: "//h2[contains(text(), 'Your Addresses')]",
  addAddressLink: "ya-myab-address-add-link",
  fullNameField: "address-ui-widgets-enterAddressFullName",
  phoneNumberField: "address-ui-widgets-enterAddressPhoneNumber",
  postalCodeField: "address-ui-widgets-enterAddressPostalCode",
  addressLine1Field: "address-ui-widgets-enterAddressLine1",
  addressLine2Field: "address-ui-widgets-enterAddressLine2",
  landmarkField: "address-ui-widgets-landmark",
  defaultAddressCheckbox: "address-ui-widgets-use-as-my-default",
  submitButton:
    "//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']",
  addressSavedText: "//h4[normalize-space()='Address saved']",
  addressText: "Address saved",
  // Cart page locators

  addToCartButton:
    "//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']",
  closeCartButton: "attach-close_sideSheet-link",
  cartCount: "#nav-cart-count",
  cartcountno: "1",
  addtocart: "Add to cart",

  //deals
  todaysDealsLink: ".nav-a[href='/deals?ref_=nav_cs_gb']",
  thirdDeal: "(//div[contains(@class,'GridItem-module__container')])[2]",

  //home
  amazonUrl: "https://www.amazon.in/",
  mainPageBody: "body",

  //login page
  signInButton: "nav-link-accountList",
  emailField: "email",
  continueButton: "input[type='submit']",
  passwordField: "password",
  signInSubmitButton: "signInSubmit",
  primeDeliveryLink: "//a[normalize-space()='Mobiles']",
  primeDeliveryCheckbox:
    "//label[@for='apb-browse-refinements-checkbox_0']//i[@class='a-icon a-icon-checkbox']",
  primeDeliveryButton: "#a-autoid-1-announce",
  accountGreeting: "nav-link-accountList-nav-line-1",
  loginText: "Hello, Supraja",

  // Navigation locators
  hamburgerMenuButton: "nav-hamburger-menu",
  mobilesCategory: "ul[class='hmenu hmenu-visible'] li:nth-child(16)",
  closeMenuButton: "hmenu-close-icon",
  verifyMobilesClick: "hmenu-customer-avatar-icon",

  // Orders page locators
  ordersButton: "nav-orders",
  pastOrderButton: "a-autoid-1-announce",
  timeFilter: "time-filter_3",
  verifyPastOrder:
    "div[class='a-column a-span3'] span[class='a-color-secondary a-text-caps']",
  orderText: "ORDER PLACED",

  // Payments page locators
  cartButton: "nav-cart",
  proceedToCheckoutButton: "input[value='Proceed to checkout']",
  selectShipToThisAddress:
    "input[data-testid='Address_selectShipToThisAddress']",
  otherUpiApps: "//div[@aria-label='Other UPI Apps']",
  enterUpiIdPlaceholder: "Enter UPI ID",
  validateUpiIdButton: "//input[@name='ppw-widgetEvent:ValidateUpiIdEvent']",
  verifiedText: "//div[contains(text(),'Verified!')]",
  paymentVerify: "Verified!",

  // Search page locators
  searchBox: "twotabsearchtextbox",
  searchButton: "nav-search-submit-button",
  lastDisplayedItemContainer: "//div[contains(@class,'puis-card-container')]",
  lastDisplayedItemTitle: "h2 span",
  lastDisplayedItemPrice: ".a-price-whole",
  verifysearch: ".a-color-state.a-text-bold",
  mobilesText: "Mobiles",
};
