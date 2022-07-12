package com.crmly.pages;

import com.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//td[@class='files-del-btn']/span[@class='del-but']")
    public WebElement delButton;


    @FindBy(name = "bxu_files[]")
    public WebElement UploadFilesAndImages;

    @FindBy(xpath= "//div[@id='post-buttons-bottom']//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement UploadFile;

    @FindBy(xpath = "//div[@class='menu-popup-items']//span[text()='Appreciation']")
    public WebElement Appreciation;

    @FindBy(css = "span#feed-add-post-form-link-text")
    public WebElement More;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement Link;

    @FindBy()
    public WebElement Cancel;

    @FindBy(xpath = "(//span[@class='feed-post-more-text'])[1]")
    public WebElement ActiveMore;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and text()='Delete']")
    public WebElement ActiveDelete;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
