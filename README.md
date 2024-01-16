# Parent Simulator

## Reflection:
First, you will enter a title screen, and after clicking the play button, you will move to a tutorial, which will briefly
describe how to play this game. Click the screen, and move to a story line. Then the game will start. 

On the main page, there are three buttons on the left top corner which correspond to three minigames. There will be
flashing finger points towards the three buttons to mention you play the minigames. 

Below the three buttons are the place to show the status of the child. Playing mini-games, scheduling time table 
and answering questions can change the points of these four statuses. When the child’s status changed, there will 
be a text shown beside the status section with fade effect to mention how many points changed. 

At the central top, there’s a line of text showing the life stage of the child. The background image will be 
changed if the life stage changed. Once the life stage goes to the “adult” stage, you cannot schedule your child 
anymore. You can only play all three games and schedule three times in order to check the result of your child’s career. 

On the main page, there are three buttons on the left top corner which correspond to three minigames. There will be
flashing finger points towards the three buttons to mention you play the minigames. Below the three buttons are the
place to show the status f the child. Playing mini-games, scheduling time table and answering questions can change
the points of these four statuses. When the child’s status changed, there will be a text shown beside the status 
section, with a fade effect to mention how many points changed. At the central top, there’s a line of text showing 
the life stage of the child. The background image will be changed if the life stage changed. Once the life stage 
goes to the “adult” stage, you cannot schedule your child anymore. You can only play all three games and schedule
three times in order to check the result of your child’s career. 

### The chess minigame
The button looks like chess is the access to the chess game.  As long as the player clicked on
it, the chess game will be started. The chess game has its intro page, game page and end page. It has a unique 
background sound. In the game, the player shall not touch the border, the player finished faster, and the points 
the player can get are bigger. There are two end pages, win and lose. They both have their sound effects. Click 
the screen to back to the main page.

### The pixel art minigame
The button looks like a video game console is an access to the pixel art game.  As long as
the player clicked on it, the pixel game will be started. The player can find the tutorial on the left side of the
page. Click the number to get the colour, and hold the space bar to pain on the screen. Each cell has a number on 
it to remind the player which colour to fill. If the player fills in the wrong colour, the number on that cell will
not disappear and can be overwritten by another colour. The opposite is true if the correct colour is filled. The 
faster you finished, the higher points you get. This game shares the same result page as the memory game. It has 
win-and-loose sound effects with unique background music. There’s a flashing text to mention the player to click 
the screen to move on to the main page. 

### The memory minigame 
The button looks like a video game console is access to the memory minigame.  As long as the 
player clicked on it, the player will move to the intro page of the memory game. Then the flashing texts will 
mention the player clicking the screen to play the game. Once the player clicked, the game begins. The player can 
get one point if they match a pair of cards. The time limitation is 1min. Click the card can flip one card with a 
click sound effect.  If the player successfully matches a pair of cards, the matched two cards will disappear and
play a sound effect. The result page shares with pixel art minigame, with win-loose sound effects and its unique 
background music (different from pixel art game). There’s a flashing text to mention the player to click the 
screen to move on to the main page. 

### The schedule
Click the schedule button will move on to the schedule section. Players can drag the activity they 
like on the timetable. There is a flashing text to mention the player filling in the timetable. If players did not
drag the activity to a proper place and release their mice, the activity will fly to its original place. If 
players drag the activity into the central part of the blank cell of the timetable, the activity will be 
automatically set into the cell with sound effects. The already settled activity can change its location in 
the timetable but is not allowed to cancel. After filling in all the cells in the timetable, a finish button 
will show on the screen, which allows the player to move to the activity effect page. The activities will show 
on the screen in the order that the player dragged with a fade effect. There will be two questions to let the 
player choose, which can affect the child’s status. It will automatically go back to the main page once it is 
finished showing the activities and questions. The schedule button will disappear from the main page once the 
child goes into adulthood. If the player finishes three minigames, the schedule button will be replaced by the 
result button to check the result of your child.

### Result
Once the player finished three minigames and three schedules, the result button will come out. Click the
result button, and move to the result page. The first page is a transition, wait several seconds, and the career 
of the child will come out. Then a flashing text will tell the player to click the screen to see the other 
player’s results in a score board along with a restart button. Click the restart button to replay the game.

### Rubric checklist:
- Proposal - DONE;
- Planning tasks - DONE;
- Use graphics and sound - DONE;
- Story/theme - DONE;
- Class diagram of 2-3 main classes- DONE;
- Submit source code as .gfar - DONE;
- A feature-complete game - DONE;
- Central code managing game data with 2d array of objects - DONE(the ScheudleWorld, all of the three games are all based on the 2d arryas. ScheudleWorld, Chessboard, MemoryGameWorld use 2d array of objects, PixelArtWorld uses 2d array  of int);
- Use of the UserInfo class - DONE;
- An ArrayList, Stack or Queue to manage events or other significant elements - DONE(Queue used in ActivityEffectWorld, ArrayList used in ScheduleWorld, ChessBoard, MemoryGameWorld and PixelArtWorld);

### Credits
Pointing Finger by Dave Gandy
<a href="https://www.flaticon.com/free-icons/arrow" title="arrow icons">
Arrow icons created by Dave Gandy - Flaticon</a>

Chess Sound:
Music by <a href="https://pixabay.com/users/lexin_music-288419
48/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_
campaign=music&amp;utm_content=115672">Lexin_Music</a> from <a hr
ef="https://pixabay.com//?utm_source=link-attribution&amp;utm_medi
um=referral&amp;utm_campaign=music&amp;utm_content=115672">Pixabay</a>

Pixel Sound:
Music by <a href="https://pixabay.com/users/nullhertz-29811401/?utm_s
ource=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&
amp;utm_content=120336">Nullhertz</a> from <a href="https://pixabay.co
m/music//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_ca
mpaign=music&amp;utm_content=120336">Pixabay</a>

Memory Sound:
Music by <a href="https://pixabay.com/users/music_for_videos-26992513/?u
tm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music
&amp;utm_content=110855">Music_For_Videos</a> from <a href="https://pixa
bay.com//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_ca
mpaign=music&amp;utm_content=110855">Pixabay</a>

Chess fail sound:
Sound Effect by <a href="https://pixabay.com/users/universfield-28281460/
?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=mu
sic&amp;utm_content=126515">Universfield</a> from <a href="https://pixab
ay.com/sound-effects//?utm_source=link-attribution&amp;utm_medium=referr
al&amp;utm_campaign=music&amp;utm_content=126515">Pixabay</a>

MianWorld background music:
Music by <a href="https://pixabay.com/users/23117649-23117649/?utm_sourc
e=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;ut
m_content=7741">23117649</a> from <a href="https://pixabay.com//?utm_sou
rce=link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;
utm_content=7741">Pixabay</a>

Win Sound:
Sound Effect from <a href="https://pixabay.com/?utm_source=link-attributi
on&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=6297">P
ixabay</a>

Fail sound:
Sound Effect from <a href="https://pixabay.com/?utm_source=link-attributi
on&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=6008">Pixabay</a>

Sound effect of puli:
Sound Effect from <a href="https://pixabay.com/sound-effects/?utm_source=
link-attribution&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_
content=102844">Pixabay</a>

get married picture by RapidEye
https://www.istockphoto.com/photo/male-and-female-hands-clasped-gm931136214-255235764
https://hackspirit.com/differences-between-falling-in-love-and-flowing-in-love/

pregnant picture
https://www.madeformums.com/pregnancy/early-pregnancy-tests-are-giving-too-many-false-results/
https://www.thehealthy.com/pregnancy/positive-pregnancy-test/

hospital picture
https://unsplash.com/s/photos/hospital-room
https://wexnermedical.osu.edu/blog/patients-value-control-privacy-in-hospital-rooms

baby pic
https://www.peakpx.com/en/hd-wallpaper-desktop-alevu

backgroundMusic
Music by <a href="https://pixabay.com/users/23117649-23117649/?utm_source=link-attributi
on&amp;utm_medium=referral&amp;utm_campaign=music&amp;utm_content=7741">23117649</a> from
<a href="https://pixabay.com//?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_c
ampaign=music&amp;utm_content=7741">Pixabay</a>

welcome picture by dpproductions
https://www.istockphoto.com/photos/front-door
https://abeautifulmess.com/first-things-first-a-pink-front-door/

story block by user2104819
https://www.freepik.com/premium-vector/set-ui-elements-2d-games-apps-jungle-game-ui-part-2_4267333.htm

arrows by user22934206
https://www.freepik.com/premium-vector/collection-set-wooden-game-ui-frame-template-pop-up-interface-gui-asset-elements_11707777.htm#from_view=detail_alsolike

The other little sound effect: https://pixabay.com
Background image from: https://www.pinterest.ca/pin/18366310973098552/

Wood background from Vecteezy (has been edited)
https://www.vecteezy.com/free-vector/cartoon-wood

Chess piece images from Wikimedia Commons (have been edited)
https://commons.wikimedia.org/wiki/Category:SVG_chess_pieces

KNOWN BUG: The timer keeps counting down when the player pauses the mini game. 
As a result, this bug messes up with the overall scoring system as it displays negative time elapsed.
