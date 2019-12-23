import React, { Component } from 'react';
import './App.css';
import Movie from './Movie';



const movies = [
    {
        title : "Matrix",
        poster: "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_.jpg"
    },
    {
        title : "Full Metal Jacket",
        poster: "https://m.media-amazon.com/images/M/MV5BNzkxODk0NjEtYjc4Mi00ZDI0LTgyYjEtYzc1NDkxY2YzYTgyXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"
    },
    {
        title : "Old boy",
        poster : "https://upload.wikimedia.org/wikipedia/en/thumb/b/bb/Oldboy_2013_film_poster.jpg/220px-Oldboy_2013_film_poster.jpg"
    },
    {
        title : "Star wars",
        poster: "https://cdn2.unrealengine.com/Diesel%2Fproductv2%2Fstar-wars-jedi-fallen-order%2Fhome%2FSWFJO_Standard_Keyart_1920x1080-1920x1080-7a42241ea451299ac73036ac61eb73c1184753e0.jpg"
    }

]

// 몇 개인지 모르는 리스트 출력
class App extends Component {
    render() {
        return (
            <div className="App">
                {movies.map((movie, index) => {
                    return <Movie title={movie.title} poster={movie.poster} key={index} />
                })}
            </div>
        )
    }
}

export default App;
