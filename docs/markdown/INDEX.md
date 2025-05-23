#### Basics markdown use cases (for Github)

***
# Headers
```
# Header 1
## Header 2
### Header 3
#### Header 4
##### Header 5
###### Header 6
```
# Header 1
## Header 2
### Header 3
#### Header 4
##### Header 5
###### Header 6
___

# Highlighting

```
Two tildes = strikethrough. ~~Scratch this.~~

Italic *asterics* or _underscores_. 

Bold **asterics** or _underscores__.

Combined highlightning *asterics or __underscores__.*

```
Two tildes = strikethrough. ~~Scratch this.~~

Italic *asterics* or _underscores_. 

Bold **asterics** or __underscores__.

Combined highlightning *asterics or __underscores__.*

___

# Links 
```
[This is an inline-style link to keepassxc.org](https://keepassxc.org/)

[This is an inline-style link with title (try to hover over)](https://www.virtualbox.org/ "Virtualbox's homepage")

[This is a reference-style link][Arbitrary case insensitive reference text]

[This is a relative reference to a repository file](../blob/main/customers/index.html) ???

[Integer numbers can be used for reference-style link definitions][1]

You can use [just link itself]

[arbitrary case insensitive reference text]: https://librewolf.net/

[1]: https://tails.boum.org/

[just link itself]: https://www.virustotal.com/gui/home/upload
```
[This is an inline-style link to ubuntu.com](https://ubuntu.com/)

[This is an inline-style link with title (try to hover over)](https://www.virtualbox.org/ "Virtualbox's homepage")

[This is a reference-style link][Arbitrary case insensitive reference text]

[This is a relative reference to a repository file](../blob/main/customers/index.html) ???

[Integer numbers can be used for reference-style link definitions][1]

You can use [just link itself]


[arbitrary case insensitive reference text]: https://librewolf.net/

[1]: https://tails.boum.org/

[just link itself]: https://www.virustotal.com/gui/home/upload

URL's will be shown as links. https://eraser.heidi.ie/
___

# Images
```
Favicon from 2_CSS_Confident project (hover over to see the alt text):

Inline-style:
![alt text](https://github.com/autopilotcode/2_CSS_Confident/blob/main/favicon.png "Alt text 1")

Reference-style:
![alt text][favicon]

[favicon]: https://github.com/autopilotcode/2_CSS_Confident/blob/main/favicon.png "Alt text 2"
```
Favicon from 2_CSS_Confident project (hover over to see the alt text):

Inline-style:
![alt text](https://github.com/autopilotcode/2_CSS_Confident/blob/main/favicon.png "Alt text 1")

Reference-style:
![alt text][favicon]

[favicon]: https://github.com/autopilotcode/2_CSS_Confident/blob/main/favicon.png "Alt text 2"


# Blockquotes
```
> Blockquotes are good for emphasizing the text.
> This is the part of the same quote.

Simple text.

> This is a long text that will be quoted when it wraps. The text can be any length, that's why I'm still writing the second sentence of this blockquote. As long the text as better example we have.

```
> Blockquotes are good for emphasizing the text.
> This is the part of the same quote.

Simple text.

> This is a long text that will be quoted when it wraps. The text can be any length, that's why I'm still writing the second sentence of this blockquote. As long the text as better example we have.

# Inline HTML
```
<h3>Header 3</h3>
<p>and paragraph is here.</p>

<h3>Markdown not the best solution for HTML.</h3>
<p><b>Use </b>*HTML* <i>tags </i>**instead.**</p>
```
<h3>Header 3</h3>
<p>and paragraph is here.</p>

<h3>Markdown not the best solution for HTML.</h3>
<p><b>Use </b>*HTML* <i>tags </i>**instead.**</p>



```puml
@startuml
Alice --> Bob
@enduml
```

