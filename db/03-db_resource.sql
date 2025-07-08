-- 03-db_resource.sql (Tourism Platform Schema)
USE demo_resource_db;

-- Tourist Sites
CREATE TABLE IF NOT EXISTS tourist_sites (
  site_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  description TEXT,
  location POINT NOT NULL, -- For geo-coordinates
  address VARCHAR(255),
  opening_hours VARCHAR(100),
  entrance_fee DECIMAL(10,2),
  category ENUM('Museum', 'Park', 'Landmark', 'Beach', 'Historic') NOT NULL,
  average_rating DECIMAL(3,2) DEFAULT 0.00,
  PRIMARY KEY (site_id),
  SPATIAL INDEX(location)
);

-- Media (for tourist sites)
CREATE TABLE IF NOT EXISTS media (
  media_id INT NOT NULL AUTO_INCREMENT,
  site_id INT NOT NULL,
  url VARCHAR(255) NOT NULL,
  type ENUM('image', 'video', '360_view') NOT NULL,
  caption VARCHAR(100),
  PRIMARY KEY (media_id),
  FOREIGN KEY (site_id) REFERENCES tourist_sites(site_id) ON DELETE CASCADE
);

-- Reviews
CREATE TABLE IF NOT EXISTS reviews (
  review_id INT NOT NULL AUTO_INCREMENT,
  site_id INT NOT NULL,
  user_id BIGINT NOT NULL, -- References users.id from auth_db
  rating TINYINT NOT NULL CHECK (rating BETWEEN 1 AND 5),
  comment TEXT,
  review_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (review_id),
  FOREIGN KEY (site_id) REFERENCES tourist_sites(site_id) ON DELETE CASCADE
);

-- Activities
CREATE TABLE IF NOT EXISTS activities (
  activity_id INT NOT NULL AUTO_INCREMENT,
  site_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  description TEXT,
  duration_minutes INT,
  price DECIMAL(10,2),
  capacity INT,
  PRIMARY KEY (activity_id),
  FOREIGN KEY (site_id) REFERENCES tourist_sites(site_id) ON DELETE CASCADE
);

-- Bookings
CREATE TABLE IF NOT EXISTS bookings (
  booking_id INT NOT NULL AUTO_INCREMENT,
  user_id BIGINT NOT NULL, -- References users.id from auth_db
  activity_id INT NOT NULL,
  booking_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  visit_date DATE NOT NULL,
  participants INT DEFAULT 1,
  total_price DECIMAL(10,2) NOT NULL,
  status ENUM('pending', 'confirmed', 'cancelled') DEFAULT 'pending',
  PRIMARY KEY (booking_id),
  FOREIGN KEY (activity_id) REFERENCES activities(activity_id)
);

-- Itineraries
CREATE TABLE IF NOT EXISTS itineraries (
  itinerary_id INT NOT NULL AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  name VARCHAR(100) NOT NULL,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  start_date DATE,
  end_date DATE,
  PRIMARY KEY (itinerary_id)
);

-- Itinerary Items (sites to visit)
CREATE TABLE IF NOT EXISTS itinerary_items (
  item_id INT NOT NULL AUTO_INCREMENT,
  itinerary_id INT NOT NULL,
  site_id INT NOT NULL,
  visit_date DATE,
  visit_order INT NOT NULL,
  notes TEXT,
  PRIMARY KEY (item_id),
  FOREIGN KEY (itinerary_id) REFERENCES itineraries(itinerary_id) ON DELETE CASCADE,
  FOREIGN KEY (site_id) REFERENCES tourist_sites(site_id)
);

-- Admin Operations Log
CREATE TABLE IF NOT EXISTS admin_operations (
  operation_id INT NOT NULL AUTO_INCREMENT,
  admin_id BIGINT NOT NULL, -- References users.id from auth_db
  operation_type ENUM('create', 'update', 'delete', 'moderate') NOT NULL,
  target_type ENUM('site', 'review', 'activity') NOT NULL,
  target_id INT NOT NULL,
  operation_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  details TEXT,
  PRIMARY KEY (operation_id)
);

-- Sample Data Insertions
INSERT INTO tourist_sites (name, description, location, address, category) VALUES
('Mountain Peak', 'Breathtaking views from the highest point in the region', ST_Point(34.0522, -118.2437), '100 Summit Rd', 'Landmark'),
('Historic Downtown', 'Well-preserved 19th century architecture', ST_Point(34.0259, -118.7798), 'Main Street', 'Historic');

INSERT INTO media (site_id, url, type) VALUES
(1, 'https://example.com/media/mountain1.jpg', 'image'),
(1, 'https://example.com/media/mountain_video.mp4', 'video'),
(2, 'https://example.com/media/downtown1.jpg', 'image');

INSERT INTO activities (site_id, name, description, price) VALUES
(1, 'Guided Sunrise Hike', 'Early morning hike with expert guide', 25.00),
(2, 'Historical Walking Tour', '2-hour tour of historic landmarks', 15.00);