
Feature: Sending Appreciation

  Background: Login with HR credentials
    Given The user logged in

  @REM-822 @wip @mus @us19
  Scenario Outline: Verify that <FileTypeOrSize> file from local disks should be uploaded
    When     User clicks Appreciation subheading from More tab
    And      User click Upload files and images after clicking upload file icon
    And      User upload "<FileName>" file
    Then     System display the uploaded "<FileName>" file under the Attached files and images section

    Examples:
      | FileTypeOrSize | FileName         |
      | txt            | test2.txt        |
      | mp3            | sample2.mp3      |
      | mp4            | sample2.mp4      |
      | 0 byte         | 0_ByteFile2      |
      | 100 Mb         | 100MbFile2.exe   |
      | No_extension   | NoExtensionFile2 |

  @REM-823 @wip
  Scenario: Verify user is able to delete uploaded file before sending the appreciation
    When User clicks Appreciation subheading from More tab
    And User click Upload files and images after clicking upload file icon
    And User upload "test2.txt" file
    And Click X button on the right side of uploaded file to delete
    Then System shouldn't display the uploaded file under the Attached files and images section

  @REM-824 @wip @us19
  Scenario: Verify that file name should be same and display after uploading the file.
    When User clicks Appreciation subheading from More tab
    And User click Upload files and images after clicking upload file icon
    And User upload "test2.txt" file
    Then System display the name of uploaded file as "test2.txt"

  @REM-825 @wip
  Scenario: Verify that users should be added by selecting multiple contacts from Employees and Departments contact lists
    When User clicks Appreciation subheading from More tab
    And User clicks Employees and departments Tab after clicking Add More
    And User select the multiple contacts from list
      | hr86@cybertekschool.com |
      | hr84@cybertekschool.com |
      | hr85@cybertekschool.com |
    Then User should be able to see selected contacts in To: input box
      | hr86@cybertekschool.com |
      | hr84@cybertekschool.com |
      | hr85@cybertekschool.com |

  @REM-826 @wip
  Scenario Outline: Verify that attach a link that have link text & link URL by clicking on the link icon.
    When User clicks Appreciation subheading from More tab
    And User clicks link icon
    And User enters link text "<LinkText>" and link URL "<LinkURL>"
    And User clicks Save button
    Then User should see attached link which has only Link URL or LinkText and URL "<LinkText>" "<LinkURL>"
    Examples:
      | LinkText | LinkURL                  |
     #| google   | https://www.google.com/  |
      |          | https://www.google.com/  |
      #| hotmail  | https://www.hotmail.com/ |

  @REM-827 @wip
    #bug
  Scenario: Verify that user shouldn't be able to attach link that have link text but no URL by clicking on the link icon.
    When User clicks Appreciation subheading from More tab
    And User clicks link icon
    And User enters link text "google" and link URL ""
    And User clicks Save button
    Then Verify that user shouldn't be able to attach link "google" without link URL

  @REM-828 @wip
  Scenario Outline: Verify that insert videos by clicking on the video icon and entering the <VideoSource> video URL.
    When User clicks Appreciation subheading from More tab
    And User clicks insert video icon
    And User enters "<VideoURL>"
    And User click Save button
    Then User should be able to see inserted video "<VideoURL>"
    Examples:
      | VideoSource | VideoURL                                    |
      | Youtube     | https://www.youtube.com/watch?v=k-7jJP7QFEM |
      | Vimeo       | https://vimeo.com/26                        |

  @REM-829 @wip
  Scenario: Verify that user shouldn't be able to insert videos by clicking on the video icon and entering the invalid video URL.
    When User clicks Appreciation subheading from More tab
    And User clicks insert video icon
    And User enters invalid video URL "invalidvideo.com"
    Then User should see the warning Incorrect URL

  @REM-830 @wip @demo
  Scenario: Verify that send appreciation with content to at least one person
    When User clicks Appreciation subheading from More tab
    And Write "anything" as a content in Appreciation
    And Add "hr98@cybertekschool.com" contact by clicking to Add more
    And User clicks send
    Then User should be able to see sent Appreciation "anything" on the top of the Active Stream

  @REM-831 @wip
  Scenario: Verify that user shouldnt be able to send appreciation without content.
    When User clicks Appreciation subheading from More tab
    And Add "hr98@cybertekschool.com" contact by clicking to Add more
    And User clicks send
    Then User should see the warning of message is not specified

  @REM-832 @wip
  Scenario: Verify that user shouldnt be able to send appreciation without any contact.
    When User clicks Appreciation subheading from More tab
    And Write "anything" as a content in Appreciation
    And User clicks send
    Then User should see the warning of specify at least one person