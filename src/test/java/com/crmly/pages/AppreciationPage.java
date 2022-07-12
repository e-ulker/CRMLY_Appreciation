package com.crmly.pages;

import com.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AppreciationPage {

    public AppreciationPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ol[@class='feed-add-post-strings-blocks']//span[@class='feed-add-post-destination-text']")
    public List<WebElement> contactNames;

    @FindBy(xpath = "//ol[@class='feed-add-post-strings-blocks']//a[@id='bx-destination-tag']")
    public WebElement AddMore;

    @FindBy(linkText = "Employees and departments")
    public WebElement EmployeesAndDepartments;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement LinkText;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement LinkURL;

    @FindBy(className = "adm-btn-save")
    public WebElement SaveButton;

    @FindBy(xpath = "//span[@title='Insert video']")
    public WebElement InsertVideoButton;

    @FindBy(xpath = "//input[@id='video_idPostFormLHE_blogPostForm-source']")
    public WebElement VideoURL;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement VideoSaveButton;

    @FindBy(xpath = "(//div[@class='bx-core-popup-menu bx-core-popup-menu-bottom bx-core-popup-menu-level0 bx-core-popup-menu-no-icons bx-core-popup-menu-editor']//span[text()='Delete video'])[3]")
    public WebElement DeleteVideo;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement Content;

    @FindBy(css = "button#blog-submit-button-save")
    public WebElement SendButton;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement DeleteAllContactButton;




}
