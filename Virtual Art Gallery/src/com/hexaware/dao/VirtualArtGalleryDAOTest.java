package com.hexaware.dao;
import com.hexaware.entity.Artist;
import com.hexaware.entity.Artwork;
import com.hexaware.entity.Gallery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualArtGalleryDAOTest {

    private VirtualArtGalleryDAO artGalleryDAO;

    @BeforeEach
    void setUp() {
        artGalleryDAO = new VirtualArtGalleryDAO();
    }

    // --- Artist + Artwork Test ---

    @Test
    void testAddArtistAndArtwork() throws Exception {
        Artist artist = new Artist("Test Artist", "Test Biography", "1990-01-01", "Indian", "http://test.com", "contact@test.com");
        artGalleryDAO.addArtist(artist);

        List<Artist> artists = artGalleryDAO.getAllArtists();
        int artistId = artists.get(artists.size() - 1).getArtistID();

        Artwork artwork = new Artwork("Sunset", "A sunset view", LocalDate.now(), "Oil", "url/to/image", artistId);
        artGalleryDAO.addArtwork(artwork);

        List<Artwork> allArtworks = artGalleryDAO.getAllArtworks();
        boolean artworkExists = allArtworks.stream().anyMatch(a -> a.getTitle().equals("Sunset"));
        assertTrue(artworkExists, "Artwork should have been added successfully.");
    }

    @Test
    void testUpdateArtwork() throws Exception {
        testAddArtistAndArtwork(); // Ensure artist and artwork exist

        List<Artwork> allArtworks = artGalleryDAO.getAllArtworks();
        Artwork artwork = allArtworks.get(allArtworks.size() - 1);

        artwork.setTitle("Sunset Revised");
        artGalleryDAO.updateArtwork(artwork);

        Artwork updatedArtwork = artGalleryDAO.getArtwork(artwork.getArtworkID());
        assertNotNull(updatedArtwork);
        assertEquals("Sunset Revised", updatedArtwork.getTitle());
    }

    @Test
    void testDeleteArtwork() throws Exception {
        testAddArtistAndArtwork(); // Ensure data exists

        List<Artwork> allArtworks = artGalleryDAO.getAllArtworks();
        int artworkId = allArtworks.get(allArtworks.size() - 1).getArtworkID();

        artGalleryDAO.deleteArtwork(artworkId);
        Artwork deleted = artGalleryDAO.getArtwork(artworkId);
        assertNull(deleted, "Artwork should have been deleted successfully.");
    }

    @Test
    void testGetAllArtworks() throws Exception {
        List<Artwork> artworks = artGalleryDAO.getAllArtworks();
        assertNotNull(artworks);
    }

    // --- Gallery Tests ---

    @Test
    void testAddGallery() throws Exception {
        // Insert curator artist first
        Artist curator = new Artist("Curator A", "Curator Bio", "1985-02-02", "France", "http://curator.com", "curator@art.com");
        artGalleryDAO.addArtist(curator);
        List<Artist> artists = artGalleryDAO.getAllArtists();
        int curatorId = artists.get(artists.size() - 1).getArtistID();

        Gallery gallery = new Gallery("Nature Gallery", "Nature themed gallery", "Delhi", curatorId, "10AM-6PM");
        artGalleryDAO.addGallery(gallery);

        List<Gallery> galleries = artGalleryDAO.getAllGalleries();
        boolean exists = galleries.stream().anyMatch(g -> g.getName().equals("Nature Gallery"));
        assertTrue(exists, "Gallery should have been added successfully.");
    }

    @Test
    void testUpdateGallery() throws Exception {
        testAddGallery(); // Ensure gallery exists
        List<Gallery> galleries = artGalleryDAO.getAllGalleries();
        Gallery gallery = galleries.get(galleries.size() - 1);

        gallery.setName("Modern Art Gallery");
        artGalleryDAO.updateGallery(gallery);

        Gallery updated = artGalleryDAO.getGallery(gallery.getGalleryID());
        assertEquals("Modern Art Gallery", updated.getName());
    }

    @Test
    void testDeleteGallery() throws Exception {
        testAddGallery(); // Ensure gallery exists
        List<Gallery> galleries = artGalleryDAO.getAllGalleries();
        int galleryId = galleries.get(galleries.size() - 1).getGalleryID();

        artGalleryDAO.deleteGallery(galleryId);
        Gallery deleted = artGalleryDAO.getGallery(galleryId);
        assertNull(deleted, "Gallery should have been deleted.");
    }

    @Test
    void testGetAllGalleries() throws Exception {
        List<Gallery> galleries = artGalleryDAO.getAllGalleries();
        assertNotNull(galleries);
    }
}