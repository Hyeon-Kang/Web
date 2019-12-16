from django.shortcuts import render
from .forms import SigninForm, SignupForm #이전에 만든 form 클래스를 선언해주고
from django.http.response import HttpResponseRedirect
from django.urls.base import reverse
from django.contrib.auth.models import User #User 모델을 사용하기위해 선언해준다.
from customlogin.models import user_profile
from django.contrib.auth import login, authenticate
#login과 authenticate 기능을 사용하기위해 선언
#login은 login처리를 해주며, authenticate는 아이디와 비밀번호가 모두 일치하는 User 객체를 추출

def signup(request):#역시 GET/POST 방식을 사용하여 구현
    if request.method == "GET":
        return render(request, 'customlogin/signup.html', {'f':SignupForm()} )


    elif request.method == "POST":
        form = SignupForm(request.POST)
        if form.is_valid():
            if form.cleaned_data['password']  == form.cleaned_data['password_check']:
#cleaned_data는 사용자가 입력한 데이터, 검사용으로  추가함

                new_user = User.objects.create_user(form.cleaned_data['username'],form.cleaned_data['email'],form.cleaned_data['password'])
#User.object.create_user는 사용자가 입력한 name, email, password를 가지고 아이디를 만든다.
#바로 .save를 안해주는 이유는 User.object.create를 먼저 해주어야 비밀번호가 암호화되어 저장된다.

                # new_user.first_name = form.cleaned_data['first_name']
#나머지 입력하지 못한 last_name과, first_name은 따로 지정해준다.
                new_user.save()

                return HttpResponseRedirect(reverse('recorder:index'))
            else:
                return render(request, 'customlogin/signup.html',{'f':form, 'error':'비밀번호와 비밀번호 확인이 다릅니다.'})#password와 password_check가 다를 것을 대비하여 error를 지정해준다.

        else:
            return render(request, 'customlogin/signup.html',{'f':form})




def signin(request):#로그인 기능
    if request.method == "GET":
        return render(request, 'customlogin/signin.html', {'f':SigninForm()} )

    elif request.method == "POST":
        form = SigninForm(request.POST)
        id = request.POST['username']
        pw = request.POST['password']
        u = authenticate(username=id, password=pw)
#authenticate를 통해 DB의 username과 password를 클라이언트가 요청한 값과 비교한다.
#만약 같으면 해당 객체를 반환하고 아니라면 none을 반환한다.

        if u: #u에 특정 값이 있다면
            login(request, user=u) #u 객체로 로그인해라
            return HttpResponseRedirect(reverse('recorder:index'))
        else:
            return render(request, 'customlogin/signin.html',{'f':form, 'error':'아이디나 비밀번호가 일치하지 않습니다.'})

from django.contrib.auth import logout #logout을 처리하기 위해 선언

def signout(request): #logout 기능
    logout(request) #logout을 수행한다.
    return HttpResponseRedirect(reverse('recorder:index'))



 abstractUser 클래스로 User model를  상속받아 확장해 쓰면 위에거 다 필요없음

def get_point(request):
    t = CustomUser.objects.get(username="test1" )
    t.point += 5000
    t.save()

    return HttpResponse("finish")
(원본)

# html에 삽입되는 form
<form action = "/recorder/get_point/" method="post">
    <button name="get_p" value="{{user.username}}">5000 point 구매</button>
    # value에 db record 식별을 위해 로그인한 유저 값을 저장.
    # 이미 매칭해놓은 url을 따라 get_p의 값이 전달됨
</form>

# views.py 에 선언
def get_point(request):

    get_p = request.POST['get_p'] # POST 전송으로 받은 get_p의 값을 다음 함수에서 지정한 get_p로 저장
    # 저장 되는 값은 value 에 들어있던 user.username 스트링 데이터

    t = CustomUser.objects.get(username= get_p )
    # CustomUser Table에서 username 컬럼이 get_p와 일치하는 record 를 불러와 t에 저장
    t.point += 5000
    # 해당 record의 point 컬럼에 + 5000
    t.save()
    # 해당 레코드 저장

    return HttpResponse("충전 완료") # 리턴 안 쓰면 오류 뜨더라. 그냥 텍스트 반환 시킴 나중에 링크로 바꿔도 됨

def buy_filter1(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    t.point -= 2500
    t.filter1 = True
    t.save()

    return HttpResponse("filter1 구매 완료")

def buy_filter2(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    t.point -= 2500
    t.filter2 = True
    t.save()

    return HttpResponse("filter2 구매 완료")

def buy_filter3(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    t.point -= 2500
    t.filter3 = True
    t.save()

    return HttpResponse("filter3 구매 완료")

def buy_filter4(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    t.point -= 2500
    t.filter4 = True
    t.save()

    return HttpResponse("filter4 구매 완료")

def buy_filter5(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    t.point -= 2500
    t.filter5 = True
    t.save()

    return HttpResponse("filter5 구매 완료")

def buy_filter6(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    t.point -= 2500
    t.filter6 = True
    t.save()

    return HttpResponse("filter6 구매 완료")





urls
from .views import buy_filter1
from .views import buy_filter2
from .views import buy_filter3
from .views import buy_filter4
from .views import buy_filter5
from .views import buy_filter6


path('buy_filter1/', views.buy_filter1, name='buy_filter1'),
path('buy_filter2/', views.buy_filter2, name='buy_filter2'),
path('buy_filter3/', views.buy_filter3, name='buy_filter3'),
path('buy_filter4/', views.buy_filter4, name='buy_filter4'),
path('buy_filter5/', views.buy_filter5, name='buy_filter5'),
path('buy_filter6/', views.buy_filter6, name='buy_filter6'),

path('buy_filter1/', views.get_point, name='buy_filter1'),


if selectval = 1
else if selectval =2
else if selectval =3
else if selectval =4
else if selectval =5
else if selectval =6

html

<form action = "/recorder/get_point/" method="post">
    <button name="get_p" value="{{user.username}}">5000 point 구매</button>
</form>

<form action = "/recorder/buy_filter1/" method="post">
    <button name="filter_choice" value="{{user.username}}">Filter1 구매</button>
</form>
