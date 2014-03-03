package de.waksh.aposoft.controller;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.waksh.aposoft.domain.ActiveIngredient;
import de.waksh.aposoft.domain.Address;
import de.waksh.aposoft.domain.Country;
import de.waksh.aposoft.domain.Customer;
import de.waksh.aposoft.domain.Insurance;
import de.waksh.aposoft.domain.PaymentCondition;
import de.waksh.aposoft.domain.Product;
import de.waksh.aposoft.domain.ProductGroup;
import de.waksh.aposoft.domain.ProductShape;
import de.waksh.aposoft.domain.ProductType;
import de.waksh.aposoft.domain.Recipe;
import de.waksh.aposoft.domain.Unit;
import de.waksh.aposoft.domain.Vendor;
import de.waksh.aposoft.repository.ActiveIngredientRepository;
import de.waksh.aposoft.repository.AddressRepository;
import de.waksh.aposoft.repository.CountryRepository;
import de.waksh.aposoft.repository.CustomerRepository;
import de.waksh.aposoft.repository.InsuranceRepository;
import de.waksh.aposoft.repository.PaymentConditionRepository;
import de.waksh.aposoft.repository.ProductGroupRepository;
import de.waksh.aposoft.repository.ProductRepository;
import de.waksh.aposoft.repository.ProductShapeRepository;
import de.waksh.aposoft.repository.ProductTypeRepository;
import de.waksh.aposoft.repository.UnitRepository;
import de.waksh.aposoft.repository.VendorRepository;
import de.waksh.aposoft.view.MainFrame;

@Component
public class MainController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private InsuranceRepository insuranceRepository;

    @Autowired
    private PaymentConditionRepository paymentConditionRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductShapeRepository productShapeRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ActiveIngredientRepository activeIngredientRepository;

    @Autowired
    private NavigationController navigationController;

    @Autowired
    private CustomerRepository customerRepository;

    private MainFrame mainFrame;

    public MainController() {
        mainFrame = new MainFrame();
    }

    @PostConstruct
    private void postConstruct() {
        mainFrame.postConstruct(navigationController.getNavigationPanel().getPanel());
        populate();
    }

    public JFrame getFrame() {
        return mainFrame.getFrame();
    }

    public void setCenter(JPanel panel) {
        JFrame frame = mainFrame.getFrame();

        if (frame.getContentPane().getComponentCount() >= 2) {
            frame.getContentPane().remove(mainFrame.getLayout().getLayoutComponent(BorderLayout.CENTER));
        }

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void setRight(JPanel panel) {
        JFrame frame = mainFrame.getFrame();

        if (frame.getContentPane().getComponentCount() >= 3) {
            frame.getContentPane().remove(mainFrame.getLayout().getLayoutComponent(BorderLayout.EAST));
        }

        frame.getContentPane().add(panel, BorderLayout.EAST);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    private void populateCountries() {
        for (int i = 0; i < 10; i++) {
            Country country = new Country();
            country.setName("country_" + i);
            country.setCountryCode("country_code_" + i);
            countryRepository.save(country);
        }
    }

    private void populateInsurances() {
        for (int i = 0; i < 10; i++) {
            Insurance insurance = new Insurance();
            insurance.setInsuranceIdNumber("insurancenumber_" + i);
            insurance.setName("name_" + i);
            insurance.setPhone("phone_" + i);
            insurance.setPrivateInsurance(new Random().nextBoolean());
            insuranceRepository.save(insurance);
        }
    }

    private void populateCustomers() {
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer();
            Address address = getAddress();
            Insurance insurance = insuranceRepository.findOne(new Random().nextInt(9) + 1);
            PaymentCondition paymentCondition = getPaymentCondition();
            customer.setAddress(address);
            customer.setBirthdate(new DateTime(1990, 12, 1, 0, 0));
            customer.setFirstName("firstname_" + i);
            customer.setGender("male");
            customer.setInsurance(insurance);
            customer.setName("name_" + i);
            customer.setPaymentCondition(paymentCondition);
            customer.setTitle("Dr.");
            customerRepository.save(customer);
        }
    }

    private Address getAddress() {
        String random = UUID.randomUUID().toString();
        Country country = countryRepository.findOne(new Random().nextInt(9) + 1);
        Address address = new Address();
        address.setCity("city_" + random);
        address.setCountry(country);
        address.setEmail("email_" + random);
        address.setExtra01("extra01_" + random);
        address.setExtra02("extra02_" + random);
        address.setExtra03("extra03_" + random);
        address.setNumber("number_" + random);
        address.setPhone("phone_" + random);
        address.setPostalCode("postalcode_" + random);
        address.setStreet("street_" + random);
        return address;
    }

    private PaymentCondition getPaymentCondition() {
        PaymentCondition condition = new PaymentCondition();
        condition.setDiscountDate(new DateTime(1995, 5, 5, 0, 0));
        condition.setDiscountValue(new Random().nextFloat() * new Random().nextInt(50));
        condition.setPaymentDate(new DateTime(1996, 6, 6, 0, 0));
        return condition;
    }

    private Recipe getRecipe() {
        String random = UUID.randomUUID().toString();

        List<ActiveIngredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ActiveIngredient ai = new ActiveIngredient();
            ai.setName(UUID.randomUUID().toString());
            ingredients.add(ai);
        }
        Recipe recipe = new Recipe();
        recipe.setDescription("recipe_" + random);
        recipe.setType("type_" + random);
        recipe.setActiveIngredients(ingredients);
        // activeIngredientRepository.save(ingredients);
        return recipe;
    }

    private void populateVendors() {
        for (int i = 0; i < 10; i++) {
            Vendor vendor = new Vendor();
            Address address = getAddress();
            vendor.setAddress(address);
            vendor.setName("vendor_" + i);
            vendor.setVendorCode("vendorcode_" + i);
            vendor.setWebsite("website_" + i);
            vendorRepository.save(vendor);
        }
    }

    private void populateUnits() {
        for (int i = 0; i < 10; i++) {
            Unit unit = new Unit();
            unit.setName("unit_" + i);
            unitRepository.save(unit);
        }
    }

    private void populateProductGroups() {
        for (int i = 0; i < 10; i++) {
            ProductGroup group = new ProductGroup();
            group.setDescription("description_" + i);
            group.setName("group_" + i);
            productGroupRepository.save(group);
        }
    }

    private void populateProductShapes() {
        for (int i = 0; i < 10; i++) {
            ProductShape shape = new ProductShape();
            shape.setName("shape_" + i);
            productShapeRepository.save(shape);
        }
    }

    private void populateProductTypes() {
        for (int i = 0; i < 10; i++) {
            ProductType type = new ProductType();
            type.setName("type_" + i);
            productTypeRepository.save(type);
        }
    }

    private void populateProducts() {
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            Vendor vendor = vendorRepository.findOne(new Random().nextInt(9) + 1);
            Unit unit = unitRepository.findOne(new Random().nextInt(9) + 1);
            Recipe recipe = getRecipe();
            ProductGroup productGroup = productGroupRepository.findOne(new Random().nextInt(9) + 1);
            ProductShape productShape = productShapeRepository.findOne(new Random().nextInt(9) + 1);
            ProductType productType = productTypeRepository.findOne(new Random().nextInt(9) + 1);
            product.setBestBeforeDate(new LocalDate(2012, 5, 12));
            product.setDosage(new Random().nextInt(20));
            product.setName("product_" + i);
            product.setPrescription(new Random().nextBoolean());
            product.setPrice(new Random().nextFloat() * new Random().nextInt(150));
            product.setProductGroup(productGroup);
            product.setProductShape(productShape);
            product.setProductType(productType);
            product.setRecipe(recipe);
            // product.setStore(store);
            product.setUnit(unit);
            product.setVendor(vendor);

            productRepository.save(product);
        }
    }

    private void populate() {
        populateCountries();
        populateInsurances();
        populateUnits();
        populateVendors();
        populateProductGroups();
        populateProductShapes();
        populateProductTypes();

        populateCustomers();
        populateProducts();
    }

}
