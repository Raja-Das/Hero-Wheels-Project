import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import ProductList from './ProductList';
import CategoryFilter from './CategoryFilter';


function App() {
  const [products, setProducts] = useState([]);  // <-- add this
  const [count, setCount] = useState(0);
  const [categories, setCategories] = useState([]); 
  const [selectedCategory, setSelectedCategory] = useState(null); 
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
    .then(response => response.json())
    .then(data => setProducts(data))
    .catch(err => console.error("Error fetching products:", err));  // <-- add this

    fetch('http://localhost:8080/api/categories')
    .then(response => response.json())
    .then(data => setCategories(data))
    .catch(err => console.error("Error fetching categories:", err));  // <-- add this
  }, []);


  const handleSearchChange = (event) => {
        setSearchTerm(event.target.value);
  };

  const handleSortChange = (event) => {
        setSortOrder(event.target.value);
  };

  const handleCategorySelect = (categoryIdOrName) => {
  setSelectedCategory(categoryIdOrName || null);
};

const filteredProducts = products
  .filter(product => {
    // Match by category name
    const matchCategory = selectedCategory
      ? product.category?.name === selectedCategory
      : true;


    // Search filter
    const matchSearch = product.name.toLowerCase().includes(searchTerm.toLowerCase());

    return matchCategory && matchSearch;
  })
  .sort((a, b) => {
    return sortOrder === "asc" ? a.price - b.price : b.price - a.price;
  });








  return (
    <div className='container'>
      <h1 className='my-4'>HeroWheels-By-RAJA</h1>
            <div className='row aligh-items-center mb-4'>
                            <div className='col-md-3 col-sm-12 mb-2'>
                                
                                    <CategoryFilter categories={categories} onSelect={handleCategorySelect}/>
                               
                            </div>   
                            <div className='col-md-5 col-sm-12 mb-2'>
                                <input type='text'
                                      className='form-control'
                                      placeholder='Search for products'
                                      onChange={handleSearchChange}
                                      />
                            </div>
                            <div className='col-md-4 col-sm-12 mb-2'>
                                <select className='form-control' onChange={handleSortChange}>
                                      <option value="asc">
                                          Sort by Price: Low to High
                                      </option>
                                      <option value="desc">
                                          Sort by Price: High to Low
                                      </option>
                                </select>
                            </div>
                
                 </div>
      <div>
        {
            filteredProducts.length ? (
              //Display Products
              <ProductList products={filteredProducts}/>
            ) : (<p> No Products Found!</p>)
        }
      </div>
    </div>
  )
}

export default App
