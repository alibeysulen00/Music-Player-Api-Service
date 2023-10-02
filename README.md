<h1>Playlist Service for Songs</h1>

<h3>Technologies Used</h3>

<ul>
    <li> <h4>Programming language used &nbsp;:&nbsp;&nbsp; <i> JAVA 17</i></h4> 
 </li>
    <li> <h4>Framework used :  &nbsp;&nbsp; <i> Spring Boot&nbsp;&nbsp;&nbsp;3.1.4 </i></h4> 
 </li>
    <li><h4>Database Used  &nbsp;:&nbsp;&nbsp; <i> MySQL</h4> </i> </li>
    <li> <h4>Environment in which the API is tested  &nbsp;:&nbsp;&nbsp; <i> Postman</h4> </i> </li>
    <li> <h4>Database IDE Used  &nbsp;:&nbsp;&nbsp; <i> DataGrip</h4></i>  </li>
</ul>
<br>

<h3>Services to be developed</h3>

<h4>Service 1</h4>
<hr>
<p><strong> SanatciEkle ( int albumAdet )</strong> 
<p> Adds an artist, their albums and the songs within the albums to the database.
<ul>
    <li>Name must be a random string 5 characters long  </li>
    <li> The date of establishment should be random </li>
    <li> The number of albums specified in the albumAdet variable should be added for the artist </li>
    <li> The name of each album must be a random string 10 characters long </li>
    <li> The release date of each album should be random </li>
    <li>Each album should contain a minimum of 6 and a maximum of 15 songs </li>
    <li>The name of each song must be a random string 15 characters long </li>
    <li> Returns the ID value of the added artist </li>
</ul>





<h4>Service 2</h4>
<hr>
<p><strong>calmaListesiOlustur ( int sarkiAdet, String ad )</strong> 
<p> Adds a playlist to the database and adds the desired number of songs to the playlist
<ul>
    <li>If the number of songs is 0 or the name is empty, it should give an error  </li>
    <li> If the number of songs to be added to the new list is higher than the total number of songs in the database, an error should be returned </li>
    <li> Adds a new playlist to the database, the name column becomes the name value in the parameter </li>
    <li> Randomly selects the desired number of songs from the database and adds them to this playlist </li>
    <li> Returns the ID value of the added playlist </li>
    
</ul>


<h4>Service 3</h4>
<hr>
<p><strong>calmaListesiYenile ( int calmaListesiId, int yeniSarkiAdet )</strong> 
<p> Clears songs from a playlist in the database and adds any number of new songs to the list.
<ul>
    <li>Operates on the playlist whose ID is given.  </li>
    <li> Removes all songs currently in the list from the list.</li>
    <li> Adds new songs to the list in the desired quantity. </li>
    
    
</ul>



<h4>Service 4</h4>
<hr>
<p><strong>sanatciBazliIstatistikAl ( )</strong> 
<p>Returns artist-based statistics.
<ul>
    <li>Creates a table with columns for artist name, total number of albums, total number of songs on their albums  </li>
    <li> The table is ordered from the most to the least number of songs</li>
    <li> Returns the table </li>
    
    
</ul>

