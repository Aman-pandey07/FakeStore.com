package com.aman.fakestorecom.viewmodels.shoppageviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class Item(
    val name: String,
    val type: String,
    val description: String,
    val price: String,
    val imageUrl: String // Dummy image URLs can be used here
)


data class Category(
    val name: String,
    val items: List<Item>
)

class CategoryViewModel : ViewModel() {
    // Predefined list of categories and their items
    private val allCategories = listOf(
        Category(
            "Shirt", listOf(
                Item("Casual Shirt", "Cotton", "Comfortable casual shirt.", "$25", "https://example.com/image1.jpg"),
                Item("Formal Shirt", "Polyester", "Perfect for office wear.", "$40", "https://example.com/image2.jpg"),
                Item("Denim Shirt", "Denim", "Stylish denim shirt.", "$30", "https://example.com/image3.jpg"),
                // Add more dummy items up to 6-8 per category
            )
        ),
        Category(
            "Pants", listOf(
                Item("Jeans", "Denim", "Comfortable jeans for daily wear.", "$50", "https://example.com/image4.jpg"),
                Item("Chinos", "Cotton", "Smart casual chinos.", "$45", "https://example.com/image5.jpg"),
                // More items here
            )
        ),
        // Define all 40 categories similarly
        Category("Handbag", listOf(
            Item("Leather Tote", "Handbag", "Spacious and stylish leather tote.", "$150", "https://example.com/handbag1.jpg"),
            Item("Clutch Bag", "Handbag", "Elegant evening clutch.", "$75", "https://example.com/handbag2.jpg"),
            Item("Crossbody Bag", "Handbag", "Casual crossbody bag.", "$120", "https://example.com/handbag3.jpg")
        )),
        Category("Dress", listOf(
            Item("Evening Gown", "Dress", "Perfect for special occasions.", "$200", "https://example.com/dress1.jpg"),
            Item("Summer Dress", "Dress", "Light and breezy summer dress.", "$80", "https://example.com/dress2.jpg"),
            Item("Maxi Dress", "Dress", "Comfortable and flowy maxi dress.", "$100", "https://example.com/dress3.jpg")
        )),
        Category("Scarf", listOf(
            Item("Wool Scarf", "Scarf", "Warm and cozy wool scarf.", "$30", "https://example.com/scarf1.jpg"),
            Item("Silk Scarf", "Scarf", "Elegant silk scarf.", "$50", "https://example.com/scarf2.jpg")
        )),
        Category("Heels", listOf(
            Item("Stiletto Heels", "Heels", "Elegant stiletto heels.", "$90", "https://example.com/heels1.jpg"),
            Item("Block Heels", "Heels", "Comfortable block heels.", "$85", "https://example.com/heels2.jpg")
        )),
        Category("Blouse", listOf(
            Item("Silk Blouse", "Blouse", "Luxurious silk blouse.", "$60", "https://example.com/blouse1.jpg"),
            Item("Cotton Blouse", "Blouse", "Casual cotton blouse.", "$40", "https://example.com/blouse2.jpg")
        )),
        Category("Earrings", listOf(
            Item("Hoop Earrings", "Earrings", "Classic gold hoops.", "$25", "https://example.com/earrings1.jpg"),
            Item("Stud Earrings", "Earrings", "Simple stud earrings.", "$15", "https://example.com/earrings2.jpg")
        )),
        Category("Sandals", listOf(
            Item("Flip Flops", "Sandals", "Casual summer sandals.", "$20", "https://example.com/sandals1.jpg"),
            Item("Gladiator Sandals", "Sandals", "Trendy gladiator sandals.", "$45", "https://example.com/sandals2.jpg")
        )),
        Category("Skirt", listOf(
            Item("Pencil Skirt", "Skirt", "Elegant pencil skirt.", "$35", "https://example.com/skirt1.jpg"),
            Item("A-Line Skirt", "Skirt", "Flowy A-line skirt.", "$40", "https://example.com/skirt2.jpg")
        )),
        Category("Perfume", listOf(
            Item("Floral Fragrance", "Perfume", "Fresh and floral scent.", "$60", "https://example.com/perfume1.jpg"),
            Item("Woody Perfume", "Perfume", "Warm and woody aroma.", "$75", "https://example.com/perfume2.jpg")
        )),
        Category("Watch", listOf(
            Item("Analog Watch", "Watch", "Classic analog watch.", "$150", "https://example.com/watch1.jpg"),
            Item("Smart Watch", "Watch", "High-tech smart watch.", "$250", "https://example.com/watch2.jpg")
        )),
        Category("Sunglasses", listOf(
            Item("Aviators", "Sunglasses", "Timeless aviator style.", "$80", "https://example.com/sunglasses1.jpg"),
            Item("Round Sunglasses", "Sunglasses", "Retro round frames.", "$70", "https://example.com/sunglasses2.jpg")
        )),
        Category("Sweater", listOf(
            Item("Cardigan", "Sweater", "Cozy knit cardigan.", "$55", "https://example.com/sweater1.jpg"),
            Item("Pullover", "Sweater", "Warm pullover sweater.", "$60", "https://example.com/sweater2.jpg")
        )),
        Category("Shirt", listOf(
            Item("Dress Shirt", "Shirt", "Smart dress shirt.", "$45", "https://example.com/shirt1.jpg"),
            Item("Casual Shirt", "Shirt", "Everyday casual shirt.", "$30", "https://example.com/shirt2.jpg")
        )),
        Category("Jeans", listOf(
            Item("Skinny Jeans", "Jeans", "Slim fit jeans.", "$50", "https://example.com/jeans1.jpg"),
            Item("Straight Jeans", "Jeans", "Classic straight fit.", "$55", "https://example.com/jeans2.jpg")
        )),
        Category("Cap", listOf(
            Item("Baseball Cap", "Cap", "Casual baseball cap.", "$20", "https://example.com/cap1.jpg"),
            Item("Trucker Hat", "Cap", "Classic trucker hat.", "$25", "https://example.com/cap2.jpg")
        )),
        Category("Shoes", listOf(
            Item("Running Shoes", "Shoes", "Comfortable running shoes.", "$70", "https://example.com/shoes1.jpg"),
            Item("Sneakers", "Shoes", "Stylish sneakers.", "$65", "https://example.com/shoes2.jpg")
        )),
        Category("Shorts", listOf(
            Item("Denim Shorts", "Shorts", "Casual denim shorts.", "$30", "https://example.com/shorts1.jpg"),
            Item("Cargo Shorts", "Shorts", "Utility cargo shorts.", "$35", "https://example.com/shorts2.jpg")
        )),
        Category("Jacket", listOf(
            Item("Bomber Jacket", "Jacket", "Trendy bomber jacket.", "$120", "https://example.com/jacket1.jpg"),
            Item("Leather Jacket", "Jacket", "Classic leather jacket.", "$150", "https://example.com/jacket2.jpg")
        )),
        Category("T-Shirt", listOf(
            Item("Graphic Tee", "T-Shirt", "Cool graphic t-shirt.", "$25", "https://example.com/tshirt1.jpg"),
            Item("Plain Tee", "T-Shirt", "Simple plain tee.", "$20", "https://example.com/tshirt2.jpg")
        )),
        Category("Toy Car", listOf(
            Item("Remote Control Car", "Toy Car", "Fun RC car for kids.", "$40", "https://example.com/toycar1.jpg"),
            Item("Diecast Car", "Toy Car", "Collectible diecast model.", "$30", "https://example.com/toycar2.jpg")
        )),
        Category("Sneakers", listOf(
            Item("High-Top Sneakers", "Sneakers", "Trendy high-top sneakers.", "$80", "https://example.com/sneakers1.jpg"),
            Item("Low-Top Sneakers", "Sneakers", "Casual low-top sneakers.", "$70", "https://example.com/sneakers2.jpg")
        )),
        Category("Hat", listOf(
            Item("Beanie", "Hat", "Warm winter beanie.", "$15", "https://example.com/hat1.jpg"),
            Item("Sun Hat", "Hat", "Wide-brimmed sun hat.", "$25", "https://example.com/hat2.jpg")
        )),
        Category("Backpack", listOf(
            Item("Hiking Backpack", "Backpack", "Durable hiking backpack.", "$60", "https://example.com/backpack1.jpg"),
            Item("Laptop Backpack", "Backpack", "Spacious laptop backpack.", "$70", "https://example.com/backpack2.jpg")
        )),
        Category("Socks", listOf(
            Item("Ankle Socks", "Socks", "Comfortable ankle socks.", "$10", "https://example.com/socks1.jpg"),
            Item("Knee-High Socks", "Socks", "Warm knee-high socks.", "$12", "https://example.com/socks2.jpg")
        )),
        Category("Puzzle", listOf(
            Item("Jigsaw Puzzle", "Puzzle", "500-piece jigsaw puzzle.", "$20", "https://example.com/puzzle1.jpg"),
            Item("3D Puzzle", "Puzzle", "Fun 3D puzzle.", "$25", "https://example.com/puzzle2.jpg")
        )),
        Category("New", listOf(
            Item("Trendy T-Shirt", "New", "Latest style tee.", "$20", "https://example.com/new1.jpg"),
            Item("Modern Watch", "New", "Stylish watch for everyday wear.", "$150", "https://example.com/new2.jpg")
        )),
        Category("Clothes", listOf(
            Item("Casual Jacket", "Clothes", "Stylish casual jacket.", "$70", "https://example.com/clothes1.jpg"),
            Item("Dress Pants", "Clothes", "Elegant dress pants.", "$55", "https://example.com/clothes2.jpg")
        )),
        Category("Handbag", listOf(
            Item("Leather Tote", "Handbag", "Spacious and stylish leather tote.", "$150", "https://example.com/handbag1.jpg"),
            Item("Clutch Bag", "Handbag", "Elegant evening clutch.", "$75", "https://example.com/handbag2.jpg"),
            Item("Crossbody Bag", "Handbag", "Casual crossbody bag.", "$120", "https://example.com/handbag3.jpg"),
            Item("Mini Backpack", "Handbag", "Compact mini backpack.", "$80", "https://example.com/handbag4.jpg"),
            Item("Bucket Bag", "Handbag", "Trendy bucket bag.", "$110", "https://example.com/handbag5.jpg"),
            Item("Messenger Bag", "Handbag", "Functional messenger bag.", "$90", "https://example.com/handbag6.jpg")
        )),
        Category("Dress", listOf(
            Item("Evening Gown", "Dress", "Perfect for special occasions.", "$200", "https://example.com/dress1.jpg"),
            Item("Summer Dress", "Dress", "Light and breezy summer dress.", "$80", "https://example.com/dress2.jpg"),
            Item("Maxi Dress", "Dress", "Comfortable and flowy maxi dress.", "$100", "https://example.com/dress3.jpg"),
            Item("Cocktail Dress", "Dress", "Stylish cocktail dress.", "$150", "https://example.com/dress4.jpg"),
            Item("Shift Dress", "Dress", "Elegant shift dress.", "$90", "https://example.com/dress5.jpg"),
            Item("Midi Dress", "Dress", "Trendy midi-length dress.", "$110", "https://example.com/dress6.jpg")
        )),
        Category("Scarf", listOf(
            Item("Wool Scarf", "Scarf", "Warm and cozy wool scarf.", "$30", "https://example.com/scarf1.jpg"),
            Item("Silk Scarf", "Scarf", "Elegant silk scarf.", "$50", "https://example.com/scarf2.jpg"),
            Item("Cotton Scarf", "Scarf", "Casual cotton scarf.", "$25", "https://example.com/scarf3.jpg"),
            Item("Cashmere Scarf", "Scarf", "Luxurious cashmere scarf.", "$100", "https://example.com/scarf4.jpg"),
            Item("Chiffon Scarf", "Scarf", "Light and breezy chiffon.", "$20", "https://example.com/scarf5.jpg"),
            Item("Plaid Scarf", "Scarf", "Stylish plaid scarf.", "$40", "https://example.com/scarf6.jpg")
        )),
        Category("Heels", listOf(
            Item("Stiletto Heels", "Heels", "Elegant stiletto heels.", "$90", "https://example.com/heels1.jpg"),
            Item("Block Heels", "Heels", "Comfortable block heels.", "$85", "https://example.com/heels2.jpg"),
            Item("Wedge Heels", "Heels", "Trendy wedge heels.", "$70", "https://example.com/heels3.jpg"),
            Item("Platform Heels", "Heels", "Statement platform heels.", "$100", "https://example.com/heels4.jpg"),
            Item("Kitten Heels", "Heels", "Chic kitten heels.", "$65", "https://example.com/heels5.jpg"),
            Item("Peep-Toe Heels", "Heels", "Stylish peep-toe heels.", "$80", "https://example.com/heels6.jpg")
        )),
        Category("Blouse", listOf(
            Item("Silk Blouse", "Blouse", "Luxurious silk blouse.", "$60", "https://example.com/blouse1.jpg"),
            Item("Cotton Blouse", "Blouse", "Casual cotton blouse.", "$40", "https://example.com/blouse2.jpg"),
            Item("Chiffon Blouse", "Blouse", "Light and airy chiffon blouse.", "$45", "https://example.com/blouse3.jpg"),
            Item("Lace Blouse", "Blouse", "Elegant lace blouse.", "$55", "https://example.com/blouse4.jpg"),
            Item("Satin Blouse", "Blouse", "Smooth satin blouse.", "$70", "https://example.com/blouse5.jpg"),
            Item("Printed Blouse", "Blouse", "Stylish printed blouse.", "$35", "https://example.com/blouse6.jpg")
        )),
        Category("Earrings", listOf(
            Item("Hoop Earrings", "Earrings", "Classic gold hoops.", "$25", "https://example.com/earrings1.jpg"),
            Item("Stud Earrings", "Earrings", "Simple stud earrings.", "$15", "https://example.com/earrings2.jpg"),
            Item("Drop Earrings", "Earrings", "Elegant drop earrings.", "$30", "https://example.com/earrings3.jpg"),
            Item("Chandelier Earrings", "Earrings", "Statement chandelier earrings.", "$45", "https://example.com/earrings4.jpg"),
            Item("Huggie Earrings", "Earrings", "Trendy huggie earrings.", "$20", "https://example.com/earrings5.jpg"),
            Item("Tassel Earrings", "Earrings", "Bohemian tassel earrings.", "$35", "https://example.com/earrings6.jpg")
        )),
        Category("Sandals", listOf(
            Item("Flip Flops", "Sandals", "Casual summer sandals.", "$20", "https://example.com/sandals1.jpg"),
            Item("Gladiator Sandals", "Sandals", "Trendy gladiator sandals.", "$45", "https://example.com/sandals2.jpg"),
            Item("Slide Sandals", "Sandals", "Easy-to-wear slide sandals.", "$30", "https://example.com/sandals3.jpg"),
            Item("Platform Sandals", "Sandals", "Chic platform sandals.", "$50", "https://example.com/sandals4.jpg"),
            Item("Strappy Sandals", "Sandals", "Stylish strappy sandals.", "$40", "https://example.com/sandals5.jpg"),
            Item("Espadrille Sandals", "Sandals", "Casual espadrille sandals.", "$35", "https://example.com/sandals6.jpg")
        )),
        Category("Handbag", listOf(
            Item("Leather Tote", "Handbag", "Spacious and stylish leather tote.", "$150", "https://example.com/handbag1.jpg"),
            Item("Clutch Bag", "Handbag", "Elegant evening clutch.", "$75", "https://example.com/handbag2.jpg"),
            Item("Crossbody Bag", "Handbag", "Casual crossbody bag.", "$120", "https://example.com/handbag3.jpg"),
            Item("Mini Backpack", "Handbag", "Compact mini backpack.", "$80", "https://example.com/handbag4.jpg"),
            Item("Bucket Bag", "Handbag", "Trendy bucket bag.", "$110", "https://example.com/handbag5.jpg"),
            Item("Messenger Bag", "Handbag", "Functional messenger bag.", "$90", "https://example.com/handbag6.jpg")
        )),
        Category("Dress", listOf(
            Item("Evening Gown", "Dress", "Perfect for special occasions.", "$200", "https://example.com/dress1.jpg"),
            Item("Summer Dress", "Dress", "Light and breezy summer dress.", "$80", "https://example.com/dress2.jpg"),
            Item("Maxi Dress", "Dress", "Comfortable and flowy maxi dress.", "$100", "https://example.com/dress3.jpg"),
            Item("Cocktail Dress", "Dress", "Stylish cocktail dress.", "$150", "https://example.com/dress4.jpg"),
            Item("Shift Dress", "Dress", "Elegant shift dress.", "$90", "https://example.com/dress5.jpg"),
            Item("Midi Dress", "Dress", "Trendy midi-length dress.", "$110", "https://example.com/dress6.jpg")
        )),
        Category("Scarf", listOf(
            Item("Wool Scarf", "Scarf", "Warm and cozy wool scarf.", "$30", "https://example.com/scarf1.jpg"),
            Item("Silk Scarf", "Scarf", "Elegant silk scarf.", "$50", "https://example.com/scarf2.jpg"),
            Item("Cotton Scarf", "Scarf", "Casual cotton scarf.", "$25", "https://example.com/scarf3.jpg"),
            Item("Cashmere Scarf", "Scarf", "Luxurious cashmere scarf.", "$100", "https://example.com/scarf4.jpg"),
            Item("Chiffon Scarf", "Scarf", "Light and breezy chiffon scarf.", "$20", "https://example.com/scarf5.jpg"),
            Item("Plaid Scarf", "Scarf", "Stylish plaid scarf.", "$40", "https://example.com/scarf6.jpg")
        )),
        Category("Heels", listOf(
            Item("Stiletto Heels", "Heels", "Elegant stiletto heels.", "$90", "https://example.com/heels1.jpg"),
            Item("Block Heels", "Heels", "Comfortable block heels.", "$85", "https://example.com/heels2.jpg"),
            Item("Wedge Heels", "Heels", "Trendy wedge heels.", "$70", "https://example.com/heels3.jpg"),
            Item("Platform Heels", "Heels", "Statement platform heels.", "$100", "https://example.com/heels4.jpg"),
            Item("Kitten Heels", "Heels", "Chic kitten heels.", "$65", "https://example.com/heels5.jpg"),
            Item("Peep-Toe Heels", "Heels", "Stylish peep-toe heels.", "$80", "https://example.com/heels6.jpg")
        )),
        Category("Blouse", listOf(
            Item("Silk Blouse", "Blouse", "Luxurious silk blouse.", "$60", "https://example.com/blouse1.jpg"),
            Item("Cotton Blouse", "Blouse", "Casual cotton blouse.", "$40", "https://example.com/blouse2.jpg"),
            Item("Chiffon Blouse", "Blouse", "Light and airy chiffon blouse.", "$45", "https://example.com/blouse3.jpg"),
            Item("Lace Blouse", "Blouse", "Elegant lace blouse.", "$55", "https://example.com/blouse4.jpg"),
            Item("Satin Blouse", "Blouse", "Smooth satin blouse.", "$70", "https://example.com/blouse5.jpg"),
            Item("Printed Blouse", "Blouse", "Stylish printed blouse.", "$35", "https://example.com/blouse6.jpg")
        )),
        Category("Earrings", listOf(
            Item("Hoop Earrings", "Earrings", "Classic gold hoops.", "$25", "https://example.com/earrings1.jpg"),
            Item("Stud Earrings", "Earrings", "Simple stud earrings.", "$15", "https://example.com/earrings2.jpg"),
            Item("Drop Earrings", "Earrings", "Elegant drop earrings.", "$30", "https://example.com/earrings3.jpg"),
            Item("Chandelier Earrings", "Earrings", "Statement chandelier earrings.", "$45", "https://example.com/earrings4.jpg"),
            Item("Huggie Earrings", "Earrings", "Trendy huggie earrings.", "$20", "https://example.com/earrings5.jpg"),
            Item("Tassel Earrings", "Earrings", "Bohemian tassel earrings.", "$35", "https://example.com/earrings6.jpg")
        )),
        Category("Sandals", listOf(
            Item("Flip Flops", "Sandals", "Casual summer sandals.", "$20", "https://example.com/sandals1.jpg"),
            Item("Gladiator Sandals", "Sandals", "Trendy gladiator sandals.", "$45", "https://example.com/sandals2.jpg"),
            Item("Slide Sandals", "Sandals", "Easy-to-wear slide sandals.", "$30", "https://example.com/sandals3.jpg"),
            Item("Platform Sandals", "Sandals", "Chic platform sandals.", "$50", "https://example.com/sandals4.jpg"),
            Item("Strappy Sandals", "Sandals", "Stylish strappy sandals.", "$40", "https://example.com/sandals5.jpg"),
            Item("Espadrille Sandals", "Sandals", "Casual espadrille sandals.", "$35", "https://example.com/sandals6.jpg")
        )),
        Category("Skirt", listOf(
            Item("Pencil Skirt", "Skirt", "Elegant pencil skirt.", "$35", "https://example.com/skirt1.jpg"),
            Item("A-Line Skirt", "Skirt", "Flowy A-line skirt.", "$40", "https://example.com/skirt2.jpg"),
            Item("Maxi Skirt", "Skirt", "Long and stylish maxi skirt.", "$50", "https://example.com/skirt3.jpg"),
            Item("Mini Skirt", "Skirt", "Trendy mini skirt.", "$30", "https://example.com/skirt4.jpg"),
            Item("Wrap Skirt", "Skirt", "Chic wrap skirt.", "$45", "https://example.com/skirt5.jpg"),
            Item("Pleated Skirt", "Skirt", "Elegant pleated skirt.", "$60", "https://example.com/skirt6.jpg")
        )),
        Category("Perfume", listOf(
            Item("Floral Fragrance", "Perfume", "Fresh and floral scent.", "$60", "https://example.com/perfume1.jpg"),
            Item("Woody Perfume", "Perfume", "Warm and woody aroma.", "$75", "https://example.com/perfume2.jpg"),
            Item("Citrus Perfume", "Perfume", "Lively citrus fragrance.", "$50", "https://example.com/perfume3.jpg"),
            Item("Spicy Perfume", "Perfume", "Exotic and spicy scent.", "$65", "https://example.com/perfume4.jpg"),
            Item("Vanilla Perfume", "Perfume", "Soft vanilla fragrance.", "$70", "https://example.com/perfume5.jpg"),
            Item("Aqua Perfume", "Perfume", "Refreshing aqua scent.", "$55", "https://example.com/perfume6.jpg")
        )),
        Category("Watch", listOf(
            Item("Analog Watch", "Watch", "Classic analog watch.", "$150", "https://example.com/watch1.jpg"),
            Item("Smart Watch", "Watch", "High-tech smart watch.", "$250", "https://example.com/watch2.jpg"),
            Item("Digital Watch", "Watch", "Modern digital watch.", "$100", "https://example.com/watch3.jpg"),
            Item("Luxury Watch", "Watch", "Elegant luxury watch.", "$500", "https://example.com/watch4.jpg"),
            Item("Sports Watch", "Watch", "Rugged sports watch.", "$120", "https://example.com/watch5.jpg"),
            Item("Dress Watch", "Watch", "Sophisticated dress watch.", "$200", "https://example.com/watch6.jpg")
        )),
        Category("Sunglasses", listOf(
            Item("Aviators", "Sunglasses", "Timeless aviator style.", "$80", "https://example.com/sunglasses1.jpg"),
            Item("Round Sunglasses", "Sunglasses", "Retro round frames.", "$70", "https://example.com/sunglasses2.jpg"),
            Item("Square Sunglasses", "Sunglasses", "Stylish square frames.", "$90", "https://example.com/sunglasses3.jpg"),
            Item("Cat Eye Sunglasses", "Sunglasses", "Chic cat eye shape.", "$85", "https://example.com/sunglasses4.jpg"),
            Item("Wayfarers", "Sunglasses", "Classic wayfarer design.", "$75", "https://example.com/sunglasses5.jpg"),
            Item("Sports Sunglasses", "Sunglasses", "Durable for sports.", "$100", "https://example.com/sunglasses6.jpg")
        )),
        Category("Sweater", listOf(
            Item("Pullover Sweater", "Sweater", "Casual pullover.", "$45", "https://example.com/sweater1.jpg"),
            Item("Cardigan", "Sweater", "Cozy cardigan.", "$60", "https://example.com/sweater2.jpg"),
            Item("Turtleneck Sweater", "Sweater", "Warm turtleneck.", "$50", "https://example.com/sweater3.jpg"),
            Item("Crew Neck Sweater", "Sweater", "Classic crew neck.", "$55", "https://example.com/sweater4.jpg"),
            Item("V-Neck Sweater", "Sweater", "Stylish v-neck.", "$48", "https://example.com/sweater5.jpg"),
            Item("Hooded Sweater", "Sweater", "Casual hoodie.", "$70", "https://example.com/sweater6.jpg")
        )),
    )

    private val _currentCategory = MutableStateFlow<Category?>(null)
    val currentCategory: StateFlow<Category?> = _currentCategory

    fun setCurrentCategory(categoryName: String) {
        _currentCategory.value = allCategories.find { it.name == categoryName }
    }
}
