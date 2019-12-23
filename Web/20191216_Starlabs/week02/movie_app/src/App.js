import React, { Component } from 'react';
import './App.css';
import Movie from './Movie';





// 몇 개인지 모르는 리스트 출력

// state는 직접 바꾸면 안된다.

class App extends Component {
    // Render : componentWillMount() -> render() -> componentDidMount()
    // Update componentWillReciveProps() -> shouldComponentUpdate() -> componentWillUpdate() -> render() -> component()
    state = {
        greeting: 'helloo',
        movies: [
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
    }

    // 컴포넌트 내부 자원은 state 속성이 붙는다.

    componentDidMount(){
        setTimeout(() => {
            this.setState({
                movies: [
                    ...this.state.movies, // 이 부분을 삭제하면 4초 후 새로 우가가 아닌 대체가 되버림
                    {
                        title: "Trainspotting",
                        poster: "https://upload.wikimedia.org/wikipedia/en/7/71/Trainspotting_ver2.jpg"
                    }
                ]
            })
        }, 4000)
    }

    render() {
        return (
            <div className="App">
            {this.state.greeting}
            {this.state.movies.map((movie, index) => {
                return <Movie title={movie.title} poster={movie.poster} key={index} />
            })}
            </div>
        )
    }
}

export default App;
