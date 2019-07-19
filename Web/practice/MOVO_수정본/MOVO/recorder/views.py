rom django.shortcuts import render

from django.http import HttpResponse
from django.views.decorators.csrf import csrf_exempt
from django.template import loader
from .dvc_mod.hparam import hparam as hp
from .dvc_mod.convert import set_predictor_enviroment

# login sessions
from django.urls import reverse_lazy
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from .forms import CustomUserCreationForm
from .models import CustomUser

class SignUpView(CreateView):
    form_class = CustomUserCreationForm
    success_url = reverse_lazy('login')
    template_name = 'signup.html'



def get_point(request):
    get_p = request.POST['get_p'] # Post request 객체 획득 ('get_p의 데이터 호.')
    t = CustomUser.objects.get(username= get_p ) #
    t.point += 5000 # 불러온 record에 point 5천 추가
    t.save() # commit

    return HttpResponse("충전 완료") # 단순 텍스트 출력, 링크로 바꿀 수도 있음


def get_time(request):
    get_t = request.POST['get_t'] # Post request 객체 획득 ('get_p의 데이터 호.')
    t = CustomUser.objects.get(username= get_t ) #
    t.recorded += 5000 # 불러온 record에 point 5천 추가
    t.save() # commit

    return HttpResponse("저장 완료") # 단순 텍스트 출력, 링크로 바꿀 수도 있음



def buy_filter1(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter1 = True
        t.save()
        return HttpResponse("filter1 구매 완료")
    else :
        return HttpResponse("filter1 구매 실패")

def buy_filter2(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter2 = True
        t.save()
        return HttpResponse("filter2 구매 완료")
    else :
        return HttpResponse("filter2 구매 실패")

def buy_filter3(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter3 = True
        t.save()
        return HttpResponse("filter3 구매 완료")
    else :
        return HttpResponse("filter3 구매 실패")

def buy_filter4(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter4 = True
        t.save()
        return HttpResponse("filter4 구매 완료")
    else :
        return HttpResponse("filter4 구매 실패")

def buy_filter5(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter5 = True
        t.save()
        return HttpResponse("filter5 구매 완료")
    else :
        return HttpResponse("filter5 구매 실패")

def buy_filter6(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter6 = True
        t.save()
        return HttpResponse("filter6 구매 완료")
    else :
        return HttpResponse("filter6 구매 실패")

def buy_filter7(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter7 = True
        t.save()
        return HttpResponse("filter7 구매 완료")
    else :
        return HttpResponse("filter7 구매 실패")

def buy_filter8(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter8 = True
        t.save()
        return HttpResponse("filter8 구매 완료")
    else :
        return HttpResponse("filter8 구매 실패")

def buy_filter9(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter9 = True
        t.save()
        return HttpResponse("filter9 구매 완료")
    else :
        return HttpResponse("filter9 구매 실패")

def buy_filter10(request):
    get_filter = request.POST['filter_choice']
    t = CustomUser.objects.get(username= get_filter )
    if t.point >= 2500:
        t.point -= 2500
        t.filter10 = True
        t.save()
        return HttpResponse("filter10 구매 완료")
    else :
        return HttpResponse("filter10 구매 실패")
