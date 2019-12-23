import React, { Component } from 'react';
import './App.css';
import Movie from './Movie';



const movies = [
    {
        title : "Matrix",
        poster: "https://img1.daumcdn.net/thumb/C155x225/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F66693b11a2874f5aa3f4d250b1830b261568780107021"
    },
    {
        title : "Full Metal Jacket",
        poster: "https://dhgywazgeek0d.cloudfront.net/watcha/image/upload/c_fill,h_700,q_80,w_490/v1485423697/bvacgjpzkogqdbcbo506.jpg"
    },
    {
        title : "Old boy",
        poster : "https://upload.wikimedia.org/wikipedia/en/thumb/b/bb/Oldboy_2013_film_poster.jpg/220px-Oldboy_2013_film_poster.jpg"
    },
    {
        title : "Star wars",
        poster: "https://i.ytimg.com/vi/ZXva4Z0zVK8/maxresdefault.jpg"
    }

]

// 몇 개인지 모르는 리스트 출력

// state는 직접 바꾸면 안된다.

class App extends Component {
    // Render : componentWillMount() -> render() -> componentDidMount()
    // Update componentWillReciveProps() -> shouldComponentUpdate() -> componentWillUpdate() -> render() -> component()
    state = {
        greeting: 'helloo'
    }

    componentDidMount(){
        setTimeout(() => {
            // this.state.greeting = 'something' 잘못된 예시
            this.setState({
                greeting: 'Hello again! '// 5000ms 후에 helloo -> hello again!으로 갱신
            })
        }, 5000)
    }
    render() {
        return (
            <div className="App">
                {this.state.greeting}
                {movies.map((movie, index) => {
                    return <Movie title={movie.title} poster={movie.poster} key={index} />
                })}
            </div>
        )
    }
}

export default App;
