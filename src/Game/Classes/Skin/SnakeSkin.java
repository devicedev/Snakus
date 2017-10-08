package Game.Classes.Skin;


public class SnakeSkin {

    private HeadSkin headSkin;

    private CurveSkin curveSkin;

    private StraightSkin straightSkin;

    private TailSkin tailSkin;

    private AppleSkin appleSkin;

    private BackgroundSkin backgroundSkin;

    private String skinName;

    public SnakeSkin(HeadSkin headSkin, CurveSkin curveSkin, StraightSkin straightSkin, TailSkin tailSkin, AppleSkin appleSkin, BackgroundSkin backgroundSkin, String skinName) {
        this.headSkin = headSkin;
        this.curveSkin = curveSkin;
        this.straightSkin = straightSkin;
        this.tailSkin = tailSkin;
        this.appleSkin = appleSkin;
        this.backgroundSkin = backgroundSkin;
        this.skinName = skinName;
    }

    public String getSkinName() {
        return skinName;
    }

    public void setSkinName(String skinName) {
        this.skinName = skinName;
    }

    public HeadSkin getHeadSkin() {
        return headSkin;
    }

    public void setHeadSkin(HeadSkin headSkin) {
        this.headSkin = headSkin;
    }

    public CurveSkin getCurveSkin() {
        return curveSkin;
    }

    public void setCurveSkin(CurveSkin curveSkin) {
        this.curveSkin = curveSkin;
    }

    public StraightSkin getStraightSkin() {
        return straightSkin;
    }

    public void setStraightSkin(StraightSkin straightSkin) {
        this.straightSkin = straightSkin;
    }

    public TailSkin getTailSkin() {
        return tailSkin;
    }

    public void setTailSkin(TailSkin tailSkin) {
        this.tailSkin = tailSkin;
    }

    public AppleSkin getAppleSkin() {
        return appleSkin;
    }

    public void setAppleSkin(AppleSkin appleSkin) {
        this.appleSkin = appleSkin;
    }

    public BackgroundSkin getBackgroundSkin() {
        return backgroundSkin;
    }

    public void setBackgroundSkin(BackgroundSkin backgroundSkin) {
        this.backgroundSkin = backgroundSkin;
    }
}
